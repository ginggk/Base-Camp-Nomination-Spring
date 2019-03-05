package com.gingerraymatthew.basecampnomination.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> findAll();

    List<T> oldest();

    List<T> newest();

    List<T> abc();

    List<T> ineligible();

    Optional<T> findById(Integer id);

    Boolean check(String email);

    void save(T t);
}
