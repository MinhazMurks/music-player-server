package minhaz.musicplayerserver.api.response

import java.util.UUID

data class PlaylistFeedResponse(
    val playlists: List<PlaylistResponse>
)

data class PlaylistResponse(
    val id: UUID,
    val creatorUUID: UUID,
    val name: String,
    val art: String,
    val tags: List<String>
)
