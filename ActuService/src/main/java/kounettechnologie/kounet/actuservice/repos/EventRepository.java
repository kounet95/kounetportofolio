package kounettechnologie.kounet.actuservice.repos;

import kounettechnologie.kounet.actuservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
