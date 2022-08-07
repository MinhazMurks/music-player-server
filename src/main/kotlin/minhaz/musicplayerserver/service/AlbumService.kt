package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.response.AlbumFeedResponse
import minhaz.musicplayerserver.api.response.AlbumResponse
import minhaz.musicplayerserver.model.Album
import minhaz.musicplayerserver.repository.AlbumRepository
import org.springframework.stereotype.Service

@Service
class AlbumService(
    private val albumRepository: AlbumRepository
) {
    fun getFeed(): AlbumFeedResponse {
        val albums = albumRepository.findAll()
        return AlbumFeedResponse(
            buildAlbumResponseList(albums)
        )
    }

    private fun buildAlbumResponse(album: Album): AlbumResponse {
        return AlbumResponse(
            id = album.id,
            artistUUID = album.artistUUID,
            name = album.name,
            art = album.art,
            tags = album.tags
        )
    }

    private fun buildAlbumResponseList(albums: List<Album>): List<AlbumResponse> {
        return albums.map {
            return@map buildAlbumResponse(it)
        }
    }
}
