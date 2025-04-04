package kounettechnologie.kounet.blogservice.services;

import kounettechnologie.kounet.blogservice.Mapper.BlogMapper;
import kounettechnologie.kounet.blogservice.dtos.CommentDTO;
import kounettechnologie.kounet.blogservice.dtos.CommentDTORequest;
import kounettechnologie.kounet.blogservice.entite.Comment;
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.repos.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BlogMapper blogMapper;

    public CommentService(CommentRepository commentRepository, BlogMapper blogMapper) {
        this.commentRepository = commentRepository;
        this.blogMapper = blogMapper;
    }

    public List<CommentDTO> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return blogMapper.toCommentDTOList(comments);
    }

    public CommentDTO getCommentById(Long id) throws ResourceNotFoundException {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        return blogMapper.toCommentDTO(comment);
    }

    public CommentDTO createComment(CommentDTORequest commentDTORequest) {
        Comment comment = blogMapper.toCommentEntity(commentDTORequest);
        comment = commentRepository.save(comment);
        return blogMapper.toCommentDTO(comment);
    }

    public CommentDTO updateComment(Long id, CommentDTORequest commentDTORequest) throws ResourceNotFoundException {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        comment.setContent(commentDTORequest.getContent());
        // Update other fields as necessary
        comment = commentRepository.save(comment);
        return blogMapper.toCommentDTO(comment);
    }

    public void deleteComment(Long id) throws ResourceNotFoundException {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        commentRepository.delete(comment);
    }
}
