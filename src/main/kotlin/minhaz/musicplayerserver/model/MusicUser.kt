package minhaz.musicplayerserver.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "music_user")
class MusicUser(
    @Column(name = "id")
    @Id
    val id: UUID,

    @Column(name = "username")
    val username: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "profile_picture")
    val profilePicture: String
) {
    override fun toString(): String {
        return "MusicUser(id=$id, username='$username', email='$email')"
    }
}
