CREATE TABLE IF NOT EXISTS movies (
                        id BIGSERIAL PRIMARY KEY,
                        movie_id VARCHAR(255) NOT NULL UNIQUE,
                        movie_name VARCHAR(255) NOT NULL,
                        description VARCHAR(255) NOT NULL
);