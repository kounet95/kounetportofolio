package kounettechnologie.kounet.blogservice;

import kounettechnologie.kounet.blogservice.entite.*;
import kounettechnologie.kounet.blogservice.repos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ArticleRepository articleRepository, CommentRepository commentRepository,
                                        CategoryRepository categoryRepository, UtilisateurRepository utilisateurRepository,
                                        MediaRepository mediaRepository) {
        return args -> {
            // Create categories
            Category category1 = new Category();
            category1.setName("Technology");
            Category category2 = new Category();
            category2.setName("Lifestyle");
            categoryRepository.save(category1);
            categoryRepository.save(category2);

            // Create users
            Utilisateur user1 = new Utilisateur();
            user1.setUsername("john_doe");
            user1.setEmail("john.doe@example.com");
            utilisateurRepository.save(user1);

            Utilisateur user2 = new Utilisateur();
            user2.setUsername("jane_doe");
            user2.setEmail("jane.doe@example.com");
            utilisateurRepository.save(user2);

            // Create articles
            Article article1 = new Article();
            article1.setTitle("Introduction to Spring Boot");
            article1.setContent("Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.");
            article1.setAuthor(user1);
            article1.setCategory(category1);
            article1.setCreatedAt("2025-04-01");
            article1.setPublished(true);
            article1.setUpdatedAt("2025-04-01");
            articleRepository.save(article1);

            Article article2 = new Article();
            article2.setTitle("Healthy Lifestyle Tips");
            article2.setContent("A healthy lifestyle includes regular exercise, balanced diet, and adequate sleep.");
            article2.setAuthor(user2);
            article2.setCategory(category2);
            article2.setCreatedAt("2025-04-01");
            article2.setPublished(true);
            article2.setUpdatedAt("2025-04-01");
            articleRepository.save(article2);

            // Create comments
            Comment comment1 = new Comment();
            comment1.setContent("Great article on Spring Boot!");
            comment1.setAuthor(user2);
            comment1.setArticle(article1);
            comment1.setCreatedAt("2025-04-01");
            commentRepository.save(comment1);

            Comment comment2 = new Comment();
            comment2.setContent("Very informative, thanks!");
            comment2.setAuthor(user1);
            comment2.setArticle(article2);
            comment2.setCreatedAt("2025-04-01");
            commentRepository.save(comment2);

            // Create media
            Media media1 = new Media();
            media1.setDescription("Spring Boot Tutorial Video");
            media1.setType("Video");
            media1.setUrl("http://example.com/spring-boot-tutorial");
            mediaRepository.save(media1);

            Media media2 = new Media();
            media2.setDescription("Healthy Lifestyle Infographic");
            media2.setType("Image");
            media2.setUrl("http://example.com/healthy-lifestyle-infographic");
            mediaRepository.save(media2);
        };
    }
}
