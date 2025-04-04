package kounettechnologie.kounet.blogservice.repos;

import kounettechnologie.kounet.blogservice.entite.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
