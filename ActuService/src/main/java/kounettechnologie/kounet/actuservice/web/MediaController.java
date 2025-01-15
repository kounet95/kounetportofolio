package kounettechnologie.kounet.actuservice.web;

import kounettechnologie.kounet.actuservice.dtos.MediaDTO;
import kounettechnologie.kounet.actuservice.dtos.MediaDTOResquest;
import kounettechnologie.kounet.actuservice.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actu/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @PostMapping
    public ResponseEntity<MediaDTO> createMedia(@RequestBody MediaDTOResquest mediaDTORequest) {
        MediaDTO createdMedia = mediaService.createMedia(mediaDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MediaDTO> updateMedia(@PathVariable Long id, @RequestBody MediaDTOResquest mediaDTORequest) {
        MediaDTO updatedMedia = mediaService.updateMedia(id, mediaDTORequest);
        return ResponseEntity.ok(updatedMedia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaDTO> getMediaById(@PathVariable Long id) {
        MediaDTO media = mediaService.getMediaById(id);
        return ResponseEntity.ok(media);
    }

    @GetMapping
    public ResponseEntity<List<MediaDTO>> getAllMedia() {
        List<MediaDTO> mediaList = mediaService.getAllMedia();
        return ResponseEntity.ok(mediaList);
    }
}
