CREATE TABLE IF NOT EXISTS category_movies
(
    id         BIGINT AUTO_INCREMENT,
    `name`     VARCHAR(50),
    CONSTRAINT category_movie_pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS type_movies
(
    id         BIGINT AUTO_INCREMENT,
    `name`     VARCHAR(50),
    CONSTRAINT type_movie_pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS countrys
(
    id         BIGINT AUTO_INCREMENT,
    `name`     VARCHAR(50),
    CONSTRAINT country_pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS years
(
    id         BIGINT AUTO_INCREMENT,
    `year`     BIGINT,
    CONSTRAINT year_pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS images
(
    id         BIGINT AUTO_INCREMENT,
    image      VARCHAR(255),
    CONSTRAINT image_pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS performers
(
    id         BIGINT AUTO_INCREMENT,
    `name`     VARCHAR(50),
    avatar     VARCHAR(100),
    CONSTRAINT performer_pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS directors
(
    id         BIGINT AUTO_INCREMENT,
    `name`     VARCHAR(50),
    avatar     VARCHAR(100),
    CONSTRAINT director_pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS movies
(
    id                BIGINT AUTO_INCREMENT,
    title             VARCHAR(100),
    movie             VARCHAR(255),
    trailer           VARCHAR(255),
    category_movie_id BIGINT,
    country_id        BIGINT,
    year_id           BIGINT,
    image_id          BIGINT,
    director_id       BIGINT,
    CONSTRAINT        movie_pk PRIMARY KEY (id),
    CONSTRAINT        category_movie_fk FOREIGN KEY (category_movie_id) REFERENCES category_movies(id),
    CONSTRAINT        country_fk FOREIGN KEY (country_id) REFERENCES countrys(id),
    CONSTRAINT        year_fk FOREIGN KEY (year_id) REFERENCES years(id),
    CONSTRAINT        image_fk FOREIGN KEY (image_id) REFERENCES images(id),
    CONSTRAINT        director_fk FOREIGN KEY (director_id) REFERENCES directors(id)

);
CREATE TABLE IF NOT EXISTS movie_type_movies
(
    movie_id      BIGINT,
    type_movie_id BIGINT,
    CONSTRAINT    movie_type_movie_pk PRIMARY KEY (movie_id, type_movie_id),
    CONSTRAINT    movie_type_fk FOREIGN KEY (movie_id) REFERENCES movies (id),
    CONSTRAINT    type_movie_fk FOREIGN KEY (type_movie_id) REFERENCES type_movies (id)
);
CREATE TABLE IF NOT EXISTS movie_performers
(
    movie_id     BIGINT,
    performer_id BIGINT,
    CONSTRAINT   movie_performer_pk PRIMARY KEY (movie_id, performer_id),
    CONSTRAINT   movie_perfomer_fk FOREIGN KEY (movie_id) REFERENCES movies (id),
    CONSTRAINT   performer_fk FOREIGN KEY (performer_id) REFERENCES performers (id)
);