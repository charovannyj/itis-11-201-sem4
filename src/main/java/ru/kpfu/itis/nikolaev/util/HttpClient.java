package ru.kpfu.itis.nikolaev.util;

import java.util.Map;

public interface HttpClient {
    String get(String url, Map<String, String> params);
    String post(String url, Map<String, String> params);
    String put(String url, Map<String, String> params);
    String delete(String url, Map<String, String> params);
}