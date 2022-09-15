package service;

import model.Elfo;

public interface ElfoService {
    long count();
    Elfo find(String nombre) throws Exception;
}
