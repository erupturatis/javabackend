```SQL
CREATE TABLE sessions (
    id SERIAL PRIMARY KEY,
    session_id VARCHAR(64) NOT NULL,
    username VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (username) REFERENCES admin(username)
);

```