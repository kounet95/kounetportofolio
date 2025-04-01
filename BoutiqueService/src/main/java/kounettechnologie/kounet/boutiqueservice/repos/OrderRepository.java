package kounettechnologie.kounet.boutiqueservice.repos;

import kounettechnologie.kounet.boutiqueservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
