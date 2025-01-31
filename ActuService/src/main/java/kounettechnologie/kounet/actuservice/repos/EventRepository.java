package kounettechnologie.kounet.actuservice.repos;

import kounettechnologie.kounet.actuservice.dtos.EventDTO;
import kounettechnologie.kounet.actuservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {


  }


