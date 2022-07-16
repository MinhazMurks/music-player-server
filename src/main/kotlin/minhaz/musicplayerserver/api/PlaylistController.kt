package minhaz.musicplayerserver.api

import minhaz.musicplayerserver.api.response.PlaylistFeedResponse
import minhaz.musicplayerserver.repository.MusicUserRepository
import minhaz.musicplayerserver.repository.PlaylistRepository
import minhaz.musicplayerserver.repository.SongRepository
import minhaz.musicplayerserver.service.PlaylistService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/playlists")
class PlaylistController(
    private val playlistService: PlaylistService,
    private val playlistRepository: PlaylistRepository,
    private val songRepository: SongRepository,
    private val musicUserRepository: MusicUserRepository
) {

    @GetMapping("/feed")
    fun getFeed(): ResponseEntity<PlaylistFeedResponse> {
        return ResponseEntity.ok().body(playlistService.getFeed())
    }

    @GetMapping("/test_get")
    fun test2Endpoint(): ResponseEntity<String> {
        println(songRepository.findAll())
        println(musicUserRepository.findAll())
        return ResponseEntity.ok().body("")
    }
}
