package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.Playlist
import minhaz.musicplayerserver.model.projections.PlaylistSummary
import java.util.UUID

data class PlaylistFullResponse(
    val id: UUID,
    val creator: MusicUserResponse,
    val name: String,
    val art: String,
    val songs: List<SongFullResponse>,
    val tags: List<String>
) {
    constructor(playlist: Playlist) : this(
        playlist.id,
        MusicUserResponse(playlist.creator),
        playlist.name,
        playlist.art,
        playlist.songs.map { return@map SongFullResponse(it) },
        playlist.tags
    )
}

data class PlaylistResponse(
    val id: UUID,
    val creator: MusicUserResponse,
    val name: String,
    val art: String,
    val tags: List<String>
) {
    constructor(playlist: PlaylistSummary) : this(
        playlist.id,
        MusicUserResponse(playlist.creator),
        playlist.name,
        playlist.art,
        playlist.tags
    )
}

data class PlaylistFeedResponse(
    val playlists: List<PlaylistResponse>
)
