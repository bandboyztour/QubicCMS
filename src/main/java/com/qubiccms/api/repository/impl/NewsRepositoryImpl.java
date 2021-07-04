package com.qubiccms.api.repository.impl;

import com.qubiccms.api.model.news.News;
import com.qubiccms.api.repository.Repository;

import java.util.List;
import java.util.Optional;

public class NewsRepositoryImpl implements Repository<News, String> {
    @Override
    public Optional<News> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<News>> loadAll() {
        return Optional.empty();
    }
}
