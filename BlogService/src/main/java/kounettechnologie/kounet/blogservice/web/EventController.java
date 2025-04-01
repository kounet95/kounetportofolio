package kounettechnologie.kounet.blogservice.web;

import kounettechnologie.kounet.blogservice.dtos.CommentDTO;
import kounettechnologie.kounet.blogservice.dtos.CommentDTORequest;
import kounettechnologie.kounet.blogservice.dtos.EventDTO;
import kounettechnologie.kounet.blogservice.dtos.EventDTORequest;
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.services.CommentService;
import kounettechnologie.kounet.blogservice.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actu/events")
public class EventController {
    @Autowired
    private  CommentService commentService;



    @GetMapping
    public ResponseEntity<List<CommentDTO>> getAllComments() {
        List<CommentDTO> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id)  throws ResourceNotFoundException  {
        CommentDTO comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTORequest commentDTORequest) {
        CommentDTO comment = commentService.createComment(commentDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentDTORequest commentDTORequest)  throws ResourceNotFoundException  {
        CommentDTO comment = commentService.updateComment(id, commentDTORequest);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) throws ResourceNotFoundException {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
