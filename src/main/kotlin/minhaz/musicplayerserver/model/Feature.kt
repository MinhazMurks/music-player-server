package minhaz.musicplayerserver.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "feature")
class Feature {
    @Column(name = "id")
    @Id
    lateinit var id: UUID

    @Column(name = "featured_artist")
    lateinit var artistUUID: UUID

    @ManyToOne
    @JoinColumn(name = "song_id")
    var song: Song? = null
}
