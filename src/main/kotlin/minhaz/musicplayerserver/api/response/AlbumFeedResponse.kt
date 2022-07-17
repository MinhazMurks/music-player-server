package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.Album
import java.util.UUID

data class AlbumFeedResponse(
    val albums: List<Album> = mutableListOf()
)

data class AlbumResponse(
    val id: UUID,
    val artistUUID: UUID,
    val artist: ArtistResponse?,
    val name: String,
    val tags: List<String>,
    var songs: List<AlbumSongResponse>?
)

data class AlbumSongResponse(
    val id: UUID,
    val albumUuid: UUID,
    val songUuid: UUID
)
