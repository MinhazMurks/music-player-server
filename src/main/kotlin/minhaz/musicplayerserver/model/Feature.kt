package minhaz.musicplayerserver.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "feature")
class Feature(
    @Column(name = "id")
    @Id
    val id: UUID,

    @Column(name = "featured_artist")
    val artistUUID: UUID,

    @Column(name = "song")
    val songUUID: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song")
    val song: Song? = null
) {
    override fun toString(): String {
        return "Feature(id=$id, artistUUID=$artistUUID)"
    }
}
