package repositories;

import entities.Rapport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RapportRepo extends CrudRepository<Rapport, Long> {

    @Query("SELECT r from Rapport r where r.archive=true")
    List<Rapport> findRapportByArchive();

}
