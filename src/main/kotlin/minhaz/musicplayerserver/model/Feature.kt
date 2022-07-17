package minhaz.musicplayerserver.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "feature")
class Feature(
    @Column(name = "id")
    @Id
    val id: UUID,

    @Column(name = "featured_artist")
    val artistUUID: UUID,

    @Column(name = "song")
    val songUUID: UUID
) {
    override fun toString(): String {
        return "Feature(id=$id, artistUUID=$artistUUID)"
    }
}
