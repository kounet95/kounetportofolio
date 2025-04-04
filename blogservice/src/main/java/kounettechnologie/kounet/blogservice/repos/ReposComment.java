package kounettechnologie.kounet.blogservice.repos;

import kounettechnologie.kounet.blogservice.entite.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ReposComment extends JpaRepository<Comment,Long> {

}
