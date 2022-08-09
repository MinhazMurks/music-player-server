package minhaz.musicplayerserver.model.projections

import java.util.UUID

interface ArtistSummary {
    val id: UUID
    val name: String
    val portrait: String
}
