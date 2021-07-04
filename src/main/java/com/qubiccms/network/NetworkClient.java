package com.qubiccms.network;

import com.sun.net.httpserver.Headers;

import java.net.URI;
import java.util.Optional;

public interface NetworkClient {
    Optional<ResponseData> doRequest(String uri, Method method, Headers headers, String body);
}
