package minhaz.musicplayerserver.api

import minhaz.musicplayerserver.api.response.SongFeedResponse
import minhaz.musicplayerserver.api.response.SongResponse
import minhaz.musicplayerserver.service.SongService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/song")
class SongController(
    private val songService: SongService
) {
    @GetMapping("/feed")
    @ResponseBody
    fun getFeed(): ResponseEntity<SongFeedResponse> {
        val response = songService.getFeed()
        return ResponseEntity.ok().body(response)
    }

    @GetMapping("/{songUUID}")
    @ResponseBody
    fun getSong(@PathVariable songUUID: UUID): ResponseEntity<SongResponse> {
        val response = songService.getSong(songUUID)
        return ResponseEntity.ok().body(response)
    }
}
