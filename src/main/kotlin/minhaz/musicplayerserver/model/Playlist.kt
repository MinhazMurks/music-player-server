package minhaz.musicplayerserver.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "playlist")
class Playlist() {
    @Column(name = "id")
    @Id
    lateinit var id: UUID
}
