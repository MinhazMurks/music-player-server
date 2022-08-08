package minhaz.musicplayerserver.service

import minhaz.musicplayerserver.api.exception.NotFoundException
import minhaz.musicplayerserver.api.response.ArtistResponse
import minhaz.musicplayerserver.api.response.PlaylistFeedResponse
import minhaz.musicplayerserver.api.response.PlaylistFullResponse
import minhaz.musicplayerserver.api.response.PlaylistResponse
import minhaz.musicplayerserver.model.PlaylistSong
import minhaz.musicplayerserver.repository.ArtistRepository
import minhaz.musicplayerserver.repository.PlaylistRepository
import minhaz.musicplayerserver.repository.PlaylistSongRepository
import minhaz.musicplayerserver.repository.SongRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PlaylistService(
    private val playlistRepository: PlaylistRepository,
    private val playlistSongRepository: PlaylistSongRepository,
    private val artistRepository: ArtistRepository,
    private val songRepository: SongRepository
) {
    fun getFeed(): PlaylistFeedResponse {
        val playlists = playlistRepository.findAll()
        return PlaylistFeedResponse(
            playlists.map {
                return@map PlaylistResponse(it)
            }
        )
    }

    fun getPlaylist(playlistUUID: UUID): PlaylistFullResponse {
        val playlist = playlistRepository.findById(playlistUUID)

        if (playlist.isEmpty) {
            throw NotFoundException("Playlist $playlistUUID was not found.")
        }

        val artist = artistRepository.findById(playlist.get().creatorUUID)
        val songs = playlistSongRepository.getPlaylistSongsByPlaylistUUID(playlistUUID)

        return PlaylistFullResponse(playlist.get(), ArtistResponse(artist.get()), emptyList())
    }

    fun addSongToPlaylist(playlistUUID: UUID, songUUID: UUID) {
        val song = songRepository.findById(songUUID)

        if (song.isEmpty) {
            throw NotFoundException("Song $songUUID was not found.")
        }

        val playlist = playlistRepository.findById(playlistUUID)

        if (playlist.isEmpty) {
            throw NotFoundException("Playlist $playlistUUID was not found.")
        }

        val playlistSong = PlaylistSong(
            songUUID = songUUID,
            playlistUUID = playlistUUID
        )

        playlistSongRepository.save(playlistSong)
    }
}
