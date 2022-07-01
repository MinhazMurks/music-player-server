package minhaz.musicplayerserver.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity(name = "song")
class Song() {
    @Column(name = "id")
    @Id
    lateinit var id: UUID

    @Column(name = "audio_file")
    lateinit var audioFile: String

    @Column(name = "name")
    lateinit var name: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist")
    lateinit var artist: Artist

    @OneToMany(mappedBy = "song", fetch = FetchType.LAZY, orphanRemoval = false)
    var features: MutableList<Feature> = mutableListOf()
}
