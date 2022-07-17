package minhaz.musicplayerserver.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity(name = "music_user")
class MusicUser(
    @Column(name = "id")
    @Id
    val id: UUID,

    @Column(name = "username")
    val username: String,

    @Column(name = "email")
    val email: String,

    @OneToOne(mappedBy = "musicUser")
    val artist: Artist? = null

) {
    override fun toString(): String {
        return "MusicUser(id=$id, username='$username', email='$email', artist=$artist)"
    }
}
