package com.qubiccms.network.impl;

import com.qubiccms.QubicCmsPlugin;
import com.qubiccms.network.Method;
import com.qubiccms.network.NetworkClient;
import com.qubiccms.network.ResponseData;
import com.sun.net.httpserver.Headers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class SimpleNetworkClientImpl implements NetworkClient {
    @Override
    public Optional<ResponseData> doRequest(String uri, Method method, Headers headers, String body) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(uri)
                    .openConnection();

            connection.setRequestMethod(method.name());
            connection.setDoOutput(true);

            if (headers != null) {
                headers.forEach((k, v) -> {
                    connection.addRequestProperty(k, String.join("; ", v));
                });
            }

            if (body != null) {
                connection.getOutputStream().write(body.getBytes());
                connection.getOutputStream().flush();
            }

            connection.connect();

            InputStream inputStream;

            if (connection.getResponseCode() > 299) {
                inputStream = connection.getErrorStream();
            } else {
                inputStream = connection.getInputStream();
            }

            String responseBody = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.joining());

            return Optional.of(
                    new ResponseData(
                            responseBody,
                            connection.getResponseCode()
                    )
            );
        } catch (Exception ex) {
            QubicCmsPlugin.LOGGER.log(Level.WARNING, "failed when try req " + uri + ": " + ex.getMessage());
        }
        return Optional.empty();
    }
}
