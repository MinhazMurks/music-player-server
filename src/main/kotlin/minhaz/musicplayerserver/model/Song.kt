package minhaz.musicplayerserver.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "song")
class Song(
    @Column(name = "id")
    @Id
    var id: UUID = UUID.randomUUID(),

    @Column(name = "audio_file")
    var audioFile: String,

    @Column(name = "name")
    var name: String,

    @Column(name = "art")
    val art: String,

    @Column(name = "artist")
    var artistUUID: UUID
) {

    override fun toString(): String {
        return "Song(id=$id, audioFile='$audioFile', name='$name')"
    }
}
