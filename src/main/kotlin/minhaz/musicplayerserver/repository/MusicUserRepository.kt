package minhaz.musicplayerserver.repository

import minhaz.musicplayerserver.model.MusicUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MusicUserRepository : JpaRepository<MusicUser, UUID>
