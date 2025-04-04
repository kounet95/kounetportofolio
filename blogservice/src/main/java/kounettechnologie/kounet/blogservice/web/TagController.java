package kounettechnologie.kounet.blogservice.web;


import kounettechnologie.kounet.blogservice.dtos.TagDTO;
import kounettechnologie.kounet.blogservice.dtos.TagDTORequest;
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {


    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("all")
    public ResponseEntity<List<TagDTO>> getAllTags() throws ResourceNotFoundException {
        List<TagDTO> tags = tagService.getAllTags();
        return ResponseEntity.ok(tags);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDTO> getTagById(@PathVariable Long id) throws ResourceNotFoundException{
        TagDTO tag = tagService.getTagById(id);
        return ResponseEntity.ok(tag);
    }

    @PostMapping("add")
    public ResponseEntity<TagDTO> createTag(@RequestBody TagDTORequest tagDTORequest)throws ResourceNotFoundException {
        TagDTO tag = tagService.createTag(tagDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(tag);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagDTO> updateTag(@PathVariable Long id, @RequestBody TagDTORequest tagDTORequest)throws ResourceNotFoundException {
        TagDTO tag = tagService.updateTag(id, tagDTORequest);
        return ResponseEntity.ok(tag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) throws ResourceNotFoundException{
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }
}