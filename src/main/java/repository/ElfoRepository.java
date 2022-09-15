package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElfoRepository extends CrudRepository<Elfo, Long> {
    Elfo findByNombre(String nombre);
}
