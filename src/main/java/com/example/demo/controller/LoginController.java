package com.example.demo.controller;

import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody Map<String, String> credentials, HttpServletResponse response) throws NoSuchAlgorithmException {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if (loginService.validateUser(username, password)) {
            Cookie sessionCookie = loginService.createSession(username);
            response.addCookie(sessionCookie);
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

    @GetMapping("/check")
    @ResponseBody
    public String checkSession(@CookieValue(value = "SESSIONID", required = false) String sessionId) {
        if (sessionId != null && loginService.isSessionValid(sessionId)) {
            return "Valid session";
        }
        return "Invalid session";
    }

    @PostMapping("/logout")
    @ResponseBody
    public String logout(@CookieValue(value = "SESSIONID", required = false) String sessionId, HttpServletResponse response) {
        if (sessionId != null) {
            loginService.invalidateSession(sessionId);
            Cookie cookie = new Cookie("SESSIONID", null);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            return "Logout successful";
        }
        return "No active session";
    }
}
