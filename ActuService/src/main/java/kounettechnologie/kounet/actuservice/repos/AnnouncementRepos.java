package kounettechnologie.kounet.actuservice.repos;

import kounettechnologie.kounet.actuservice.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepos extends JpaRepository<Announcement, Long> {

   // Recherche des annonces mises en avant
   List<Announcement> findByIsHighlightedTrue();

   // Recherche des annonces par contenu du message
   List<Announcement> findByMessageContainingIgnoreCase(String keyword);
}
