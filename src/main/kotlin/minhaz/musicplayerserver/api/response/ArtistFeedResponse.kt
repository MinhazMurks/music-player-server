package minhaz.musicplayerserver.api.response

import java.util.UUID

data class ArtistFeedResponse(
    val artists: List<ArtistResponse>
)

data class ArtistResponse(
    val id: UUID,
    val musicUserUUID: UUID,
    val name: String
)
