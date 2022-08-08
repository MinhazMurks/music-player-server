package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.Album
import minhaz.musicplayerserver.model.AlbumSong
import java.util.UUID

data class AlbumSongResponse(
    val id: UUID,
    val albumUuid: UUID,
    val songUuid: UUID
) {
    constructor(albumSong: AlbumSong) : this(albumSong.id, albumSong.albumUuid, albumSong.songUuid)
}

data class AlbumResponse(
    val id: UUID,
    val artistUUID: UUID,
    val artist: ArtistResponse? = null,
    val name: String,
    val art: String,
    val tags: List<String>,
    var songs: List<AlbumSongResponse>? = null
) {
    constructor(album: Album, artist: ArtistResponse?, songs: List<AlbumSongResponse>?) : this(
        album.id,
        album.artistUUID,
        artist,
        album.name,
        album.art,
        album.tags,
        songs
    )
}

data class AlbumFeedResponse(
    val albums: List<AlbumResponse> = mutableListOf()
)
