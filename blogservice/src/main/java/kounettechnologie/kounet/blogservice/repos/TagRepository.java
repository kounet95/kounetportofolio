package kounettechnologie.kounet.blogservice.repos;


import kounettechnologie.kounet.blogservice.entite.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
   // List<Tag> findByKeysContainingIgnoreCase(String keyword);
}
