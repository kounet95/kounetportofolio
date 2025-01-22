package kounettechnologie.kounet.blogservice.repos;

import kounettechnologie.kounet.blogservice.entite.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReposArticle extends JpaRepository<Article,Long> {

}
