package kounettechnologie.kounet.actuservice.repos;

import kounettechnologie.kounet.actuservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    // Méthode pour trouver les objets hérités comme Announcement en utilisant le type spécifique
    @Query("SELECT i FROM Item i WHERE TYPE(i) = Announcement")
    List<Item> findAllAnnouncements();

    @Query("SELECT i FROM Item i WHERE TYPE(i) = Announcement AND i.isHighlighted = true")
    List<Item> findHighlightedAnnouncements();

    @Query("SELECT i FROM Item i WHERE TYPE(i) = Announcement AND LOWER(i.message) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Item> searchAnnouncementsByKeyword(String keyword);
}
