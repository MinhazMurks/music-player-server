package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.Song
import java.util.UUID

data class SongFullResponse(
    val id: UUID,
    val audioFile: String,
    val name: String,
    val art: String,
    val artistId: ArtistResponse
) {
    constructor(song: Song, artist: ArtistResponse) : this(song.id, song.audioFile, song.name, song.art, artist)
}

data class SongResponse(
    val id: UUID,
    val audioFile: String,
    val name: String,
    val art: String,
    val artistId: UUID
) {
    constructor(song: Song) : this(song.id, song.audioFile, song.name, song.art, song.artistUUID)
}

data class SongFeedResponse(
    val songs: List<SongResponse>
)
