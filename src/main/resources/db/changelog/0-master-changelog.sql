CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS test_table(
    id INT,
    test_int INT
)

CREATE TABLE IF NOT EXISTS user(
    id UUID DEFAULT generate_uuid_v4(),
    username TEXT NOT NULL,
    email TEXT NOT NULL
)

CREATE TABLE IF NOT EXISTS song(
    id UUID DEFAULT generate_uuid_v4(),
    audio_file TEXT NOT NULL
    name TEXT NOT NULL
)

CREATE TABLE IF NOT EXISTS playlist(
    id UUID DEFAULT generate_uuid_v4(),
    name TEXT NOT NULL
)