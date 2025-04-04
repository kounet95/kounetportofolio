package kounettechnologie.kounet.blogservice.repos;
import kounettechnologie.kounet.blogservice.entite.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {


  }


