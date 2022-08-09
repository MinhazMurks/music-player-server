package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.MusicUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface MusicUserRepository : CustomMusicUserRepository

interface CustomMusicUserRepository : JpaRepository<MusicUser, UUID> {
    fun getMusicUserById(id: UUID): MusicUser
}
