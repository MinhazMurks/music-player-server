package minhaz.musicplayerserver.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity()
@Table(name = "artist")
public class Artist(
    @Column(name = "id")
    @Id
    val id: UUID,

    @Column(name = "music_user")
    val musicUserUUID: UUID,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "music_user", referencedColumnName = "id")
    val musicUser: MusicUser? = null,

    @Column(name = "name")
    val name: String
) {
    override fun toString(): String {
        return "Artist(id=$id, name='$name')"
    }
}
