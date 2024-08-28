CREATE TABLE user_roles (
                            user_id BIGINT NOT NULL,
                            role_name VARCHAR(50) NOT NULL,
                            FOREIGN KEY (user_id) REFERENCES users(id),
                            PRIMARY KEY (user_id, role_name)
);