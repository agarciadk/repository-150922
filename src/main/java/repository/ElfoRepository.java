package repository;

import model.Elfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElfoRepository extends CrudRepository<Elfo, Long> {
    Elfo findByNombre(String nombre);

    @Query("SELECT e FROM Elfo e")
    List<Elfo> query();

    @Query("SELECT e FROM Elfo e WHERE e.nombre = :nombre")
    Elfo query2(@Param("nombre") String nombre);

    @Query("SELECT e FROM Elfo e WHERE e.nombre = ?1")
    Elfo query3(String nombre);
}
