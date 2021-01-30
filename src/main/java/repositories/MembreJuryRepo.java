package repositories;

import entities.MembreJury;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembreJuryRepo extends CrudRepository<MembreJury, Long> {
}
