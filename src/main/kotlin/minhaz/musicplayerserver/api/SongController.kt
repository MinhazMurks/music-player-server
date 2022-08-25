package minhaz.musicplayerserver.api

import minhaz.musicplayerserver.api.response.SongFeedResponse
import minhaz.musicplayerserver.api.response.SongResponse
import minhaz.musicplayerserver.service.SongService
import okhttp3.internal.http.HTTP_PARTIAL_CONTENT
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.MimeType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody
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

    @GetMapping("/data/{songUUID}")
    @ResponseBody
    fun getSong(@PathVariable songUUID: UUID): ResponseEntity<SongResponse> {
        val response = songService.getSong(songUUID)
        return ResponseEntity.ok().body(response)
    }

    @GetMapping(value = ["/{songUUID}"])
    suspend fun streamSong(@PathVariable songUUID: UUID): ResponseEntity<StreamingResponseBody?>? {
        val songByteArray = songService.getSongChunk(songUUID, 0)
        val response = StreamingResponseBody { outputStream ->
            outputStream.write(songByteArray)
            outputStream.close()
        }

        return ResponseEntity
            .status(HTTP_PARTIAL_CONTENT)
            .contentType(MediaType.asMediaType(MimeType("audio", "mpeg")))
            .body(response)
    }
}
