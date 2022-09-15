package service;

import model.Elfo;

import java.util.List;

public interface ElfoService {
    long count();
    List<Elfo> findAll();
    Elfo find(String nombre) throws Exception;
    Elfo add(Elfo elfo);
    Elfo updateById(Long id, Elfo elfo) throws Exception;

    void deleteById(Long id) throws Exception;

    List<Elfo> query();
    Elfo query2(String nombre);
    Elfo query3(String nombre);
}
