package kounettechnologie.kounet.actuservice.repos;

import kounettechnologie.kounet.actuservice.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByKeysContainingIgnoreCase(String keyword);
}
