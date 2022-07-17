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
class Song(
    @Column(name = "id")
    @Id
    var id: UUID = UUID.randomUUID(),

    @Column(name = "audio_file")
    var audioFile: String,

    @Column(name = "name")
    var name: String,

    @Column(name = "artist")
    var artistUUID: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist")
    var artist: Artist,

    @OneToMany(mappedBy = "song", fetch = FetchType.LAZY, orphanRemoval = false)
    var features: MutableList<Feature> = mutableListOf(),
) {

    override fun toString(): String {
        return "Song(id=$id, audioFile='$audioFile', name='$name', artist=$artist, features=$features)"
    }
}
