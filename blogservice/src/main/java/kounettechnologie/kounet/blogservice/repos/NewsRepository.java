package kounettechnologie.kounet.blogservice.repos;


import kounettechnologie.kounet.blogservice.entite.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Long> {

    //List<News> findNewsByTag(Long tagId);
}
