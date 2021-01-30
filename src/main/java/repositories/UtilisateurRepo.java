package repositories;

import entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepo extends CrudRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
}
