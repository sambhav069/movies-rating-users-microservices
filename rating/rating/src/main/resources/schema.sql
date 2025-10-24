CREATE TABLE IF NOT EXISTS rating_movies (
                                             id BIGSERIAL PRIMARY KEY,
                                             userId INT NOT NULL,
                                             rating INT NOT NULL,
                                             movieId VARCHAR(255) NOT NULL
    );