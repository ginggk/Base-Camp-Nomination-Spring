package com.gingerraymatthew.basecampnomination.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> findAll();

    List<T> newest();

    List<T> abc();

    List<T> eligible();

    List<T> ineligible();

    Optional<T> findById(Integer id);

    void save(T t);
}
