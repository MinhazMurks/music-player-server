package minhaz.musicplayerserver.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "song")
class Song() {
    @Column(name = "id")
    @Id
    lateinit var id: UUID

    @Column(name = "audio_file")
    lateinit var audioFile: String
}
