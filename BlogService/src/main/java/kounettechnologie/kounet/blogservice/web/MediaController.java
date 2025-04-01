package kounettechnologie.kounet.blogservice.web;

import kounettechnologie.kounet.blogservice.dtos.MediaDTO;
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actu/media")
public class MediaController {

    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public ResponseEntity<List<MediaDTO>> getAllMedia() {
        List<MediaDTO> media = mediaService.getAllMedia();
        return ResponseEntity.ok(media);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaDTO> getMediaById(@PathVariable Long id) throws ResourceNotFoundException {
        MediaDTO media = mediaService.getMediaById(id);
        return ResponseEntity.ok(media);
    }

    @PostMapping
    public ResponseEntity<MediaDTO> createMedia(@RequestBody MediaDTO mediaDTO) throws ResourceNotFoundException{
        MediaDTO media = mediaService.createMedia(mediaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(media);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MediaDTO> updateMedia(@PathVariable Long id, @RequestBody MediaDTO mediaDTO) throws ResourceNotFoundException{
        MediaDTO media = mediaService.updateMedia(id, mediaDTO);
        return ResponseEntity.ok(media);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable Long id) throws ResourceNotFoundException {
        mediaService.deleteMedia(id);
        return ResponseEntity.noContent().build();
    }
}

