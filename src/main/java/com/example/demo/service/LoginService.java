package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean validateUser(String username, String password) {
        String sql = "SELECT password FROM admin WHERE username = ?";
        try {
            String storedPassword = jdbcTemplate.queryForObject(sql, new Object[]{username}, String.class);
            return storedPassword != null && storedPassword.equals(password);
        } catch (Exception e) {
            return false;
        }
    }

    public Cookie createSession(String username) throws NoSuchAlgorithmException {
        String sessionId = generateSessionId();
        String sql = "INSERT INTO sessions (session_id, username) VALUES (?, ?)";
        jdbcTemplate.update(sql, sessionId, username);

        Cookie cookie = new Cookie("SESSIONID", sessionId);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(24 * 60 * 60); // 1 day
        return cookie;
    }

    private String generateSessionId() throws NoSuchAlgorithmException {
        String uuid = UUID.randomUUID().toString();
        MessageDigest salt = MessageDigest.getInstance("SHA-256");
        salt.update(uuid.getBytes());
        return Base64.getEncoder().encodeToString(salt.digest());
    }

    public boolean isSessionValid(String sessionId) {
        String sql = "SELECT username FROM sessions WHERE session_id = ?";
        try {
            String username = jdbcTemplate.queryForObject(sql, new Object[]{sessionId}, String.class);
            return username != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void invalidateSession(String sessionId) {
        String sql = "DELETE FROM sessions WHERE session_id = ?";
        jdbcTemplate.update(sql, sessionId);
    }
}
