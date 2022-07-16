package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.Album

class AlbumFeedResponse(
    val albums: List<Album> = mutableListOf()
)
