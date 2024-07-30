package com.example.shortlink.utils;

import java.net.HttpURLConnection;
import java.net.URL;

public class ValidationOriginalLink {

    public static boolean isAvailable(String link) throws Exception {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(link).openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            return connection.getResponseCode() == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            return false;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}

