package minhaz.musicplayerserver.api.response

import minhaz.musicplayerserver.model.MusicUser
import java.util.UUID

data class MusicUserFullResponse(
    val id: UUID,
    val username: String,
    val email: String,
    val profilePicture: String
) {
    constructor(musicUser: MusicUser) : this(
        musicUser.id,
        musicUser.username,
        musicUser.email,
        musicUser.profilePicture
    )
}

data class MusicUserResponse(
    val id: UUID,
    val username: String,
    val profilePicture: String
) {
    constructor(musicUser: MusicUser) : this(musicUser.id, musicUser.username, musicUser.profilePicture)
}
