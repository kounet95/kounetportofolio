package kounettechnologie.kounet.actuservice;

import kounettechnologie.kounet.actuservice.entity.*;
import kounettechnologie.kounet.actuservice.repos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ActuServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            TagRepository tagRepository,
            NewsRepository newsRepository,
            EventRepository eventRepository,
            AnnouncementRepos announcementRepos,
            MediaRepository mediaRepository) {
        return args -> {
            // Création des tags
            Tag tag1 = Tag.builder().keys("Technologie").build();
            Tag tag2 = Tag.builder().keys("Innovation").build();
            Tag tag3 = Tag.builder().keys("Conférence").build();
            tagRepository.saveAll(List.of(tag1, tag2, tag3));

            // Création des actualités
            News news1 = News.builder()
                    .title("Lancement du nouveau produit")
                    .content("Nous lançons un produit révolutionnaire dans le domaine de la technologie.")
                    .category("Produit")
                    .publishedDate(LocalDate.of(2025, 1, 18))
                    .imageUrl("https://example.com/images/produit.jpg")
                    .tags(List.of(tag1, tag2))
                    .build();

            News news2 = News.builder()
                    .title("Sécurité des données : un enjeu majeur")
                    .content("La sécurité des données devient une priorité dans l'ère numérique.")
                    .category("Sécurité")
                    .publishedDate(LocalDate.of(2025, 1, 17))
                    .imageUrl("https://example.com/images/securite.jpg")
                    .tags(List.of(tag2))
                    .build();

            newsRepository.saveAll(List.of(news1, news2));

            // Création des événements
            Event event1 = Event.builder()
                    .title("Conférence sur l'Innovation")
                    .description("Une conférence sur les dernières tendances en matière d'innovation technologique.")
                    .startDate(LocalDate.of(2025, 2, 10))
                    .endDate(LocalDate.of(2025, 2, 12))
                    .location("Paris, France")
                    .isOnline(false)
                    .registrationLink("https://example.com/register")
                    .bannerUrl("https://example.com/images/event_banner.jpg")
                    .tags(List.of(tag1, tag3))
                    .build();

            eventRepository.save(event1);

            // Création des annonces
            Announcement announcement1 = Announcement.builder()
                    .title("Nouvelle version de notre application disponible!")
                    .message("Nouvelle version de notre application avec des fonctionnalités améliorées.")
                    .isHighlighted(true)
                    .build();

            Announcement announcement2 = Announcement.builder()
                    .title("Maintenance programmée")
                    .message("Notre site sera en maintenance le 20 janvier 2025.")
                    .isHighlighted(false)
                    .build();

            announcementRepos.saveAll(List.of(announcement1, announcement2));

            // Création des médias
            Media media1 = Media.builder()
                    .type("Image")
                    .url("https://example.com/images/media1.jpg")
                    .description("Bannière de l'événement")
                    .event(event1)
                    .build();

            Media media2 = Media.builder()
                    .type("Vidéo")
                    .url("https://example.com/videos/media2.mp4")
                    .description("Vidéo du produit")
                    .news(news1)
                    .build();

            mediaRepository.saveAll(List.of(media1, media2));
        };
    }
}
