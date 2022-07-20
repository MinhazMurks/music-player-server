package minhaz.musicplayerserver.api.response

import java.util.UUID

data class AlbumFeedResponse(
    val albums: List<AlbumResponse> = mutableListOf()
)

data class AlbumResponse(
    val id: UUID,
    val artistUUID: UUID,
    val artist: ArtistResponse? = null,
    val name: String,
    val art: String,
    val tags: List<String>,
    var songs: List<AlbumSongResponse>? = null
)

data class AlbumSongResponse(
    val id: UUID,
    val albumUuid: UUID,
    val songUuid: UUID
)
