package com.qubiccms.api.repository;

import java.util.List;
import java.util.Optional;

/**
 * {@link Repository} ...
 * */
public interface Repository<T, K> {
    Optional<T> getById(K k);
    Optional<List<T>> loadAll();
}
