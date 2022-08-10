package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.Artist
import minhaz.musicplayerserver.model.projections.ArtistSummary
import java.util.UUID

data class ArtistFeedResponse(
    val artists: List<ArtistResponse>
)

data class ArtistResponse(
    val id: UUID,
    val name: String,
    val portrait: String
) {
    constructor(artist: ArtistSummary) : this(
        artist.id, artist.name, artist.portrait
    )

    constructor(artist: Artist) : this(
        artist.id, artist.name, artist.portrait
    )
}
