package minhaz.musicplayerserver.api.response

import java.util.UUID

data class SongFeedResponse(
    val songs: List<SongResponse>
)

data class SongResponse(
    val id: UUID,
    val audioFile: String,
    val name: String,
    val art: String,
    val artistId: UUID
)
