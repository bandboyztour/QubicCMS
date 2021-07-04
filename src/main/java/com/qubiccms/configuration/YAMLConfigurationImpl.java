package com.qubiccms.configuration;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;
import java.util.Optional;

public class YAMLConfigurationImpl extends YamlConfiguration implements Configuration {
    @Override
    public Optional<String> getValue(String key) {
        return Optional.ofNullable(super.getString(key));
    }

    @Override
    public Optional<List<String>> getValues(String key) {
        return Optional.ofNullable(super.getStringList(key));
    }
}
