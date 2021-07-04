package com.qubiccms.api.repository.impl;

import com.qubiccms.api.model.page.Page;
import com.qubiccms.api.repository.Repository;

import java.util.List;
import java.util.Optional;

public class PagesRepositoryImpl implements Repository<Page, String> {

    @Override
    public Optional<Page> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Page>> loadAll() {
        return Optional.empty();
    }
}
