package kounettechnologie.kounet.blogservice.repos;

import kounettechnologie.kounet.blogservice.entite.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
}
