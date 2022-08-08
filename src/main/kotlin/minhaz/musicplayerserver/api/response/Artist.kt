package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.Artist
import java.util.UUID

data class ArtistFeedResponse(
    val artists: List<ArtistResponse>
)

data class ArtistResponse(
    val id: UUID,
    val musicUserUUID: UUID,
    val name: String,
    val portrait: String
) {
    constructor(artist: Artist) : this(
        artist.id, artist.musicUserUUID, artist.name, artist.portrait
    )
}
