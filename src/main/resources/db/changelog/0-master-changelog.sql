CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS music_user
(
    id       UUID DEFAULT uuid_generate_v4(),
    username TEXT NOT NULL UNIQUE,
    email    TEXT NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS artist
(
    id         UUID DEFAULT uuid_generate_v4(),
    music_user UUID NOT NULL,
    name       TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (music_user) REFERENCES music_user (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS song
(
    id         UUID DEFAULT uuid_generate_v4(),
    audio_file TEXT NOT NULL,
    name       TEXT NOT NULL,
    artist     UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (artist) REFERENCES artist (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS feature
(
    id              UUID DEFAULT uuid_generate_v4(),
    featured_artist UUID NOT NULL,
    song            UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (featured_artist) REFERENCES artist (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (song) REFERENCES song (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS playlist
(
    id        UUID   DEFAULT uuid_generate_v4(),
    name      TEXT NOT NULL,
    is_public BOOL   DEFAULT FALSE,
    tags      TEXT[] DEFAULT '{}',
    PRIMARY KEY (id)
);