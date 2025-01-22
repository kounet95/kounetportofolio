package kounettechnologie.kounet.actuservice.repos;

import kounettechnologie.kounet.actuservice.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Long> {

    List<News> findNewsByTag(Long tagId);
}
