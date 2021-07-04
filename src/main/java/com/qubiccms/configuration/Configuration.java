package com.qubiccms.configuration;

import com.qubiccms.network.NetworkClient;

import java.util.List;
import java.util.Optional;

/**
 * TODO: add Json logger, maybe using {@link com.google.gson.Gson}
 * Like:
 * [
 *      {
 *          "date": 1209349949, (unix timestamp)
 *          "level": INFO,
 *          "message": "some info message"
 *      }
 * ]
 *
 * */
public interface Configuration {
    Optional<String> getValue(String key);
    Optional<List<String>> getValues(String key);
}
