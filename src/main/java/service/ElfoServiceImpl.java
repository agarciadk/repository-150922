package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Elfo;
import repository.ElfoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ElfoServiceImpl implements ElfoService {
    private final ElfoRepository elfoRepository;

    @Autowired
    public ElfoServiceImpl(ElfoRepository elfoRepository) {
        this.elfoRepository = elfoRepository;
    }
    @Override
    public long count() {
        return elfoRepository.count();
    }

    @Override
    public List<Elfo> findAll() {
        return (List<Elfo>) elfoRepository.findAll();
    }

    @Override
    public Elfo find(String nombre) throws Exception {
        if (nombre == null) throw new IllegalArgumentException("El nombre no puede ser nulo");
        Optional<Elfo> elfo = elfoRepository.findByNombre(nombre);
        if (!elfo.isPresent()) throw new Exception("El elfo no existe");
        return elfo.get();
    }

    @Override
    public Elfo add(Elfo elfo) {
        return elfoRepository.save(elfo);
    }

    @Override
    public Elfo updateById(Long id, Elfo elfo) throws Exception {
        Optional<Elfo> searchedElfo = elfoRepository.findById(id);
        if (!searchedElfo.isPresent()) {
            throw new Exception("El elfo no existe");
        }
        elfo.setId(searchedElfo.get().getId());
        return elfoRepository.save(elfo);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!elfoRepository.findById(id).isPresent()) {
            throw new Exception("No existe la id " + id + " en la tabla Elfo");
        }
        elfoRepository.deleteById(id);
    }

    public List<Elfo> query() {
        return elfoRepository.query();
    }

    public Elfo query2(String nombre) {
        return elfoRepository.query2(nombre);
    }

    public Elfo query3(String nombre) {
        return elfoRepository.query3(nombre);
    }
}
