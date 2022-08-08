package minhaz.musicplayerserver.api

import minhaz.musicplayerserver.api.response.PlaylistFeedResponse
import minhaz.musicplayerserver.api.response.PlaylistFullResponse
import minhaz.musicplayerserver.service.PlaylistService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/playlist")
class PlaylistController(
    private val playlistService: PlaylistService
) {

    @GetMapping("/feed")
    @ResponseBody
    fun getFeed(): ResponseEntity<PlaylistFeedResponse> {
        val response = playlistService.getFeed()
        return ResponseEntity.ok().body(response)
    }

    @GetMapping("/{playlistUUID}")
    @ResponseBody
    fun getPlaylist(@PathVariable playlistUUID: UUID): ResponseEntity<PlaylistFullResponse> {
        val response = playlistService.getPlaylist(playlistUUID)
        return ResponseEntity.ok().body(response)
    }
}
