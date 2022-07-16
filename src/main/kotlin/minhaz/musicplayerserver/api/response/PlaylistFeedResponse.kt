package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.Playlist

data class PlaylistFeedResponse(
    val playlists: List<Playlist>
)
