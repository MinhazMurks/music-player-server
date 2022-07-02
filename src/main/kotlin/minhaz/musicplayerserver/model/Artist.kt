package minhaz.musicplayerserver.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity()
@Table(name = "artist")
public class Artist {
    @Column(name = "id")
    @Id
    lateinit var id: UUID

    @Column(name = "name")
    lateinit var name: String

    @OneToOne()
    @JoinColumn(name = "music_user", referencedColumnName = "id")
    var musicUser: MusicUser? = null
    override fun toString(): String {
        return "Artist(id=$id, name='$name')"
    }
}
