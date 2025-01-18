package kounettechnologie.kounet.coursservice.repos;


import kounettechnologie.kounet.coursservice.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}

