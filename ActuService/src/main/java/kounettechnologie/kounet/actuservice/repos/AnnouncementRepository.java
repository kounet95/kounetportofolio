package kounettechnologie.kounet.actuservice.repos;

import kounettechnologie.kounet.actuservice.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
