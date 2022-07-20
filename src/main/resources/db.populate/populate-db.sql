CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

insert into music_user (id, username, email)
values ('00000000-0000-0000-0000-000000000000', 'DEFAULT', 'DEFAULT'),
       ('786a5b4d-4c1a-402c-9328-821cab655405', 'user1', 'user1@email.com'),
       ('c7393a54-65f6-494c-acc6-ddbd8fec3976', 'user2', 'user2@email.com'),
       ('b3d9898e-14c6-4879-90b9-f09fd3f09952', 'user3', 'user3@email.com');

insert into artist (id, music_user, name)
values ('d7266122-908a-4791-b17a-55f7f9dd0958', '786a5b4d-4c1a-402c-9328-821cab655405', 'Wacko'),
       ('a283cac0-8951-491e-b55a-68e29f5b7e8c', 'c7393a54-65f6-494c-acc6-ddbd8fec3976', 'Colors'),
       ('53e7d574-ad04-49e5-9079-4de6c152e5ca', 'b3d9898e-14c6-4879-90b9-f09fd3f09952', 'Zander');

insert into song (id, audio_file, name, artist)
values ('7d45f414-72bb-465f-ae72-0deef85c11c4', '', 'crazy', 'd7266122-908a-4791-b17a-55f7f9dd0958'),
       ('aa9d2b5c-6d22-4e6d-9168-44491daa7774', '', 'insane', 'd7266122-908a-4791-b17a-55f7f9dd0958'),
       ('b26934f1-619a-4731-9765-21b3546c717f', '', 'unhinged', 'd7266122-908a-4791-b17a-55f7f9dd0958'),
       ('e4250c35-5653-41b0-9d31-93fa112b244e', '', 'red', 'a283cac0-8951-491e-b55a-68e29f5b7e8c'),
       ('414cb26d-3cbb-4fe8-9569-5e3618771d84', '', 'blue', 'a283cac0-8951-491e-b55a-68e29f5b7e8c');

insert into feature (featured_artist, song)
values ('a283cac0-8951-491e-b55a-68e29f5b7e8c', '7d45f414-72bb-465f-ae72-0deef85c11c4'),
       ('53e7d574-ad04-49e5-9079-4de6c152e5ca', '7d45f414-72bb-465f-ae72-0deef85c11c4');

insert into playlist (id, creator, name)
values ('aafadcf1-a913-4b0b-923d-fafa8a157fe5', '786a5b4d-4c1a-402c-9328-821cab655405');

insert into playlist_song (id, playlist, song)
values ('603c0051-9f76-4a99-8726-3df89847ecbd', 'aafadcf1-a913-4b0b-923d-fafa8a157fe5',
        '7d45f414-72bb-465f-ae72-0deef85c11c4'),
       ('603c0051-9f76-4a99-8726-3df89847ecbd', 'aafadcf1-a913-4b0b-923d-fafa8a157fe5',
        'a283cac0-8951-491e-b55a-68e29f5b7e8c');

insert into album (id, artist, name, art)
values ('e8e396a5-f354-456a-a92b-4cd501590af2', 'd7266122-908a-4791-b17a-55f7f9dd0958', 'mental',
        'https://music-server-storage.s3.amazonaws.com/Images/album-placeholder-full.webp'),
       ('7aec798e-6652-4efb-a127-c98c94cde4f6', 'a283cac0-8951-491e-b55a-68e29f5b7e8c', 'rainbow',
        'https://music-server-storage.s3.amazonaws.com/Images/album-placeholder-full.webp');

insert into album_song (id, album, song)
values ('9ac60599-30be-4c1d-a312-01e87394cc35', 'e8e396a5-f354-456a-a92b-4cd501590af2',
        '7d45f414-72bb-465f-ae72-0deef85c11c4'),
       ('0a9c24a7-5c3d-46b0-99e8-16ba72d92de3', 'e8e396a5-f354-456a-a92b-4cd501590af2',
        'aa9d2b5c-6d22-4e6d-9168-44491daa7774'),
       ('4abfea91-2ea6-4d5b-82ab-102ada1879a5', 'e8e396a5-f354-456a-a92b-4cd501590af2',
        'b26934f1-619a-4731-9765-21b3546c717f'),
       ('5463d8f8-37e3-4f21-ae9a-ee8c078506ce', '7aec798e-6652-4efb-a127-c98c94cde4f6',
        'a283cac0-8951-491e-b55a-68e29f5b7e8c'),
       ('c4567946-4b75-412e-ba55-de140c0d14c8', '7aec798e-6652-4efb-a127-c98c94cde4f6',
        'a283cac0-8951-491e-b55a-68e29f5b7e8c');