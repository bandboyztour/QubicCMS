package com.qubiccms.api.repository.impl;

import com.qubiccms.api.model.sale.Sale;
import com.qubiccms.api.repository.Repository;

import java.util.List;
import java.util.Optional;

public class SalesRepositoryImpl implements Repository<Sale, String> {
    @Override
    public Optional<Sale> getById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Sale>> loadAll() {
        return Optional.empty();
    }
}
