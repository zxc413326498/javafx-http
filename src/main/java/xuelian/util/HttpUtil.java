package xuelian.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpUtil {
    //接口
    private static final String IP_ADDRESS = "http://localhost:8080/api/doSomething";

    public static boolean sendGETString(String message) throws Exception {
        StringBuilder url = new StringBuilder(IP_ADDRESS);
        url.append("?message=");
        url.append(URLEncoder.encode(message, "UTF-8"));

        HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        return conn.getResponseCode() == 200;
    }
}
