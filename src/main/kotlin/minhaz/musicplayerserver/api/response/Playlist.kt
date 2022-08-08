package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.Playlist
import java.util.UUID

data class PlaylistFullResponse(
    val id: UUID,
    val creator: ArtistResponse,
    val name: String,
    val art: String,
    val songs: List<SongResponse>,
    val tags: List<String>
) {
    constructor(playlist: Playlist, creator: ArtistResponse, songs: List<SongResponse>) : this(
        playlist.id,
        creator,
        playlist.name,
        playlist.art,
        songs,
        playlist.tags
    )
}

data class PlaylistResponse(
    val id: UUID,
    val creatorUUID: UUID,
    val name: String,
    val art: String,
    val tags: List<String>
) {
    constructor(playlist: Playlist) : this(
        playlist.id,
        playlist.creatorUUID,
        playlist.name,
        playlist.art,
        playlist.tags
    )
}

data class PlaylistFeedResponse(
    val playlists: List<PlaylistResponse>
)
