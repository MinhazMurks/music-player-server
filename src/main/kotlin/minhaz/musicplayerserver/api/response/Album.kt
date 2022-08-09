package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.AlbumSong
import minhaz.musicplayerserver.model.projections.AlbumSummary
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
    val name: String,
    val art: String,
    val tags: List<String>
) {
    constructor(album: AlbumSummary) : this(
        album.id,
        album.artistUUID,
        album.name,
        album.art,
        album.tags,
    )
}

data class AlbumFeedResponse(
    val albums: List<AlbumResponse> = mutableListOf()
)
