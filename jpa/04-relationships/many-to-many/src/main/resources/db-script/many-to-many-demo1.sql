CREATE TYPE GENDER AS ENUM ('MALE', 'FEMALE');

CREATE TABLE actor
(
    id     VARCHAR(10) PRIMARY KEY,
    name   VARCHAR(200) NOT NULL,
    gender GENDER       NOT NULL,
    dob    DATE         NOT NULL
);

CREATE TABLE movie(
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    genre VARCHAR(40) NOT NULL,
    release_year DATE NOT NULL
);

CREATE TABLE actor_movie(
    actor_id VARCHAR(10) NOT NULL,
    movie_id VARCHAR(10) NOT NULL,
    CONSTRAINT pk_actor_movie PRIMARY KEY (actor_id, movie_id),
    CONSTRAINT fk_actor FOREIGN KEY (actor_id) REFERENCES actor (id),
    CONSTRAINT fk_movie FOREIGN KEY (movie_id) REFERENCES movie (id)
);