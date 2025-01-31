package kounettechnologie.kounet.actuservice.repos;

import kounettechnologie.kounet.actuservice.entity.Announcement;
import kounettechnologie.kounet.actuservice.entity.Event;
import kounettechnologie.kounet.actuservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    /**
     * Recherche des événements à la une.
     * @return Une liste d'événements dont la propriété `isHighlighted` est vraie.
     */
    List<Event> findByIsHighlightedTrue();

    /**
     * Recherche des événements en fonction d'un mot-clé dans le nom ou la description.
     * @param name Mot-clé pour le nom.
     * @param description Mot-clé pour la description.
     * @return Une liste des événements correspondant à la recherche.
     */
    List<Event> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);

    @Query("SELECT a FROM Announcement a")
    List<Announcement> findAllAnnouncements();

    @Query("SELECT a FROM Announcement a WHERE a.isHighlighted = true")
    List<Announcement> findHighlightedAnnouncements();

    @Query("SELECT a FROM Announcement a WHERE LOWER(a.message) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Announcement> searchAnnouncementsByKeyword(String keyword);

}
