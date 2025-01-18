package kounettechnologie.kounet.category.repos;

import kounettechnologie.kounet.category.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
