package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Elfo find(String nombre) {
        return elfoRepository.findByNombre(nombre);
    }
}
