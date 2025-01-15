package kounettechnologie.kounet.actuservice.web;

import kounettechnologie.kounet.actuservice.dtos.TagDTO;
import kounettechnologie.kounet.actuservice.dtos.TagDTORequest;
import kounettechnologie.kounet.actuservice.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<TagDTO> createTag(@RequestBody TagDTORequest tagDTORequest) {
        TagDTO createdTag = tagService.createTag(tagDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTag);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagDTO> updateTag(@PathVariable Long id, @RequestBody TagDTORequest tagDTORequest) {
        TagDTO updatedTag = tagService.updateTag(id, tagDTORequest);
        return ResponseEntity.ok(updatedTag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDTO> getTagById(@PathVariable Long id) {
        TagDTO tag = tagService.getTagById(id);
        return ResponseEntity.ok(tag);
    }

    @GetMapping
    public ResponseEntity<List<TagDTO>> getAllTags() {
        List<TagDTO> tags = tagService.getAllTags();
        return ResponseEntity.ok(tags);
    }
}
