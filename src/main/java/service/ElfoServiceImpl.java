package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Elfo;
import repository.ElfoRepository;

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
    public Elfo find(String nombre) throws Exception {
        if (nombre == null) throw new IllegalArgumentException("El nombre no puede ser nulo");
        Elfo elfo = elfoRepository.findByNombre(nombre);
        if (elfo == null) throw new Exception("El elfo no existe");
        return elfo;
    }
}
