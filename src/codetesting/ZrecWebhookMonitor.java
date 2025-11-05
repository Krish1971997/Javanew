package codetesting;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.io.IOException;

public class ZrecWebhookMonitor {

    private static final String SHORT_URL_PREFIX = "https://zrec.in/";
    private static final String ZOHO_URL_PREFIX = "https://careers.zohocorp.com";
    private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 5;
    private static final String WEBHOOK_URL = "https://webhook.site/caa5435d-afbb-489c-b92e-ed8451fcf51d"; // replace this

    private static final Set<String> foundUrls = new HashSet<>();

    public static void main(String[] args) throws Exception {
        while (true) {
            String code = generateRandomCode(CODE_LENGTH);
            String shortUrl = SHORT_URL_PREFIX + code;

            try {
                String realUrl = getFinalRedirectURL(shortUrl);

                if (realUrl != null && realUrl.startsWith(ZOHO_URL_PREFIX) && !foundUrls.contains(shortUrl)) {
                    foundUrls.add(shortUrl);
                    System.out.println("✅ New Zoho link found: " + realUrl);
                    sendWebhook(realUrl);
                }

            } catch (Exception e) {
                // ignore errors for unavailable URLs
            }

            Thread.sleep(30000); // 30 seconds pause between checks
        }
    }

    private static String generateRandomCode(int length) {
        Random random = new Random();
        StringBuilder code = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            code.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }
        return code.toString();
    }

    private static String getFinalRedirectURL(String shortUrl) throws IOException {
        String finalUrl = shortUrl;
        while (true) {
            URL url = new URL(finalUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setInstanceFollowRedirects(false);
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.setRequestMethod("HEAD");

            int status = connection.getResponseCode();
            if (status >= 300 && status < 400) {
                String newUrl = connection.getHeaderField("Location");
                if (newUrl == null) break;
                finalUrl = newUrl;
            } else {
                break;
            }
        }
        return finalUrl;
    }

    private static void sendWebhook(String url) throws IOException {
        URL webhookUrl = new URL(WEBHOOK_URL);
        HttpURLConnection connection = (HttpURLConnection) webhookUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        String payload = "{\"new_url\": \"" + url + "\", \"source\": \"zrec.in\"}";

        try (OutputStream os = connection.getOutputStream()) {
            os.write(payload.getBytes());
            os.flush();
        }

        int responseCode = connection.getResponseCode();
        System.out.println("📡 Webhook sent (Response " + responseCode + ")");
    }
}
