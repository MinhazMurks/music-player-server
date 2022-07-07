package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.Playlist

data class FeedResponse(
    val feed: List<Playlist>
)
