package minhaz.musicplayerserver.api

import minhaz.musicplayerserver.api.response.AlbumFeedResponse
import minhaz.musicplayerserver.service.AlbumService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/album")
class AlbumController(
    private val albumService: AlbumService
) {
    @GetMapping("/feed")
    @ResponseBody
    fun getFeed(): ResponseEntity<AlbumFeedResponse> {
        val response = albumService.getFeed()
        return ResponseEntity.ok().body(response)
    }
}
