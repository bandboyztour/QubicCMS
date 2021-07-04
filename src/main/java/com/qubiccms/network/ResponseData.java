package com.qubiccms.network;

public class ResponseData {
    private final String body;
    private final int statusCode;

    public ResponseData(String body, int statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "body='" + body + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
