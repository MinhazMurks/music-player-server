CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


insert into playlist (id, name, is_public, tags)
values (uuid_generate_v4(), 'playlist1', false, ARRAY ['cool', 'amazing']);

insert into music_user (id, username, email)
values ('00000000-0000-0000-0000-000000000000', 'DEFAULT', 'DEFAULT'),
       ('786a5b4d-4c1a-402c-9328-821cab655405', 'user1', 'user1@email.com'),
       ('c7393a54-65f6-494c-acc6-ddbd8fec3976', 'user2', 'user2@email.com'),
       ('b3d9898e-14c6-4879-90b9-f09fd3f09952', 'user3', 'user3@email.com');

insert into artist (id, music_user, name)
values ('d7266122-908a-4791-b17a-55f7f9dd0958', '786a5b4d-4c1a-402c-9328-821cab655405', 'John'),
       ('a283cac0-8951-491e-b55a-68e29f5b7e8c', 'c7393a54-65f6-494c-acc6-ddbd8fec3976', 'Steve'),
       ('53e7d574-ad04-49e5-9079-4de6c152e5ca', 'b3d9898e-14c6-4879-90b9-f09fd3f09952', 'Zander');


insert into song (id, audio_file, name, artist)
values ('7d45f414-72bb-465f-ae72-0deef85c11c4', '', 'song1', 'd7266122-908a-4791-b17a-55f7f9dd0958');

insert into feature (featured_artist, song)
values ('a283cac0-8951-491e-b55a-68e29f5b7e8c', '7d45f414-72bb-465f-ae72-0deef85c11c4'),
       ('53e7d574-ad04-49e5-9079-4de6c152e5ca', '7d45f414-72bb-465f-ae72-0deef85c11c4');