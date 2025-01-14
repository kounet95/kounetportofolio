package kounettechnologie.kounet.clientservice.repos;

import kounettechnologie.kounet.clientservice.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Clients,Long> {
}
