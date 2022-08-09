package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.Song
import minhaz.musicplayerserver.model.projections.SongSummary
import java.util.UUID

data class SongFullResponse(
    val id: UUID,
    val audioFile: String,
    val name: String,
    val art: String,
    val artist: ArtistResponse
) {
    constructor(song: Song) : this(song.id, song.audioFile, song.name, song.art, ArtistResponse(song.artist))
}

data class SongResponse(
    val id: UUID,
    val audioFile: String,
    val name: String,
    val art: String,
    val artistId: UUID
) {
    constructor(song: SongSummary) : this(song.id, song.audioFile, song.name, song.art, song.artistUUID)
}

data class SongFeedResponse(
    val songs: List<SongResponse>
)
