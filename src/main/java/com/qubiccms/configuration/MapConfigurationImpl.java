package com.qubiccms.configuration;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MapConfigurationImpl implements Configuration {
    private final Map<String, String> map;

    public MapConfigurationImpl(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public Optional<String> getValue(String key) {
        return Optional.ofNullable(
                map.get(key)
        );
    }

    @Override
    public Optional<List<String>> getValues(String key) {
        return Optional.empty();
    }
}
