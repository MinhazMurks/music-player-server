package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.exception.NotFoundException
import minhaz.musicplayerserver.api.response.AlbumFeedResponse
import minhaz.musicplayerserver.api.response.AlbumFullResponse
import minhaz.musicplayerserver.api.response.AlbumResponse
import minhaz.musicplayerserver.repository.AlbumRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AlbumService(
    private val albumRepository: AlbumRepository
) {
    fun getFeed(): AlbumFeedResponse {
        val albums = albumRepository.getAllByTagsNotNull()
        return AlbumFeedResponse(
            albums.map {
                return@map AlbumResponse(it)
            }
        )
    }

    fun getAlbum(albumUUID: UUID): AlbumFullResponse {
        val album = albumRepository.findById(albumUUID)

        if (album.isEmpty) {
            throw NotFoundException("Album $albumUUID was not found.")
        }

        return AlbumFullResponse(
            album.get()
        )
    }
}
