CREATE TABLE users
(
    id UUID PRIMARY KEY,

    first_name VARCHAR(100) NOT NULL,

    last_name VARCHAR(100),

    email VARCHAR(255) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL,

    profile_image_url VARCHAR(255),

    role VARCHAR(50),

    status VARCHAR(50),

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP
);


CREATE INDEX idx_user_email
ON users(email);