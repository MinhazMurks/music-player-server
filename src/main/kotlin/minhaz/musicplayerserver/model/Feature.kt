package minhaz.musicplayerserver.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "feature")
class Feature {
    @Column(name = "id")
    @Id
    lateinit var id: UUID

    @Column(name = "featured_artist")
    lateinit var artistUUID: UUID

    @ManyToOne
    @JoinColumn(name = "song")
    var song: Song? = null
    override fun toString(): String {
        return "Feature(id=$id, artistUUID=$artistUUID)"
    }
}
