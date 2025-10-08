package codetesting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class ZohoAuth {
    private static final String CLIENT_ID = "1000.8MXE4F16177CCI94VFNAVFVBUVDCVP";
    private static final String CLIENT_SECRET = "4af03f91abe12cb1cd3ec014dc698ad0b55cc242bb";
    private static final String GRANT_TYPE = "client_credentials";
    private static final String SCOPE = "ZohoSheet.dataimport.ALL,ZohoSheet.spreadsheet.ALL";

    public static String getAccessToken() throws Exception {
        URL url = new URL("https://accounts.zoho.com/oauth/v2/token"); // Use .eu for EU DC, etc.
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setDoOutput(true);

        String auth = Base64.getEncoder().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes());
        conn.setRequestProperty("Authorization", "Basic " + auth);

        String params = "grant_type=" + GRANT_TYPE + "&scope=" + SCOPE;
        try (OutputStream os = conn.getOutputStream()) {
            os.write(params.getBytes());
            os.flush();
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            // Parse JSON response for "access_token" (use Gson or manual parsing)
            return extractToken(response.toString()); // Implement extractToken to parse JSON
        }
    }

    private static String extractToken(String json) {
        // Simple string parsing; use a JSON library like Gson in production
        int start = json.indexOf("\"access_token\":\"") + 15;
        int end = json.indexOf("\"", start);
        return json.substring(start, end);
    }
    
    public static void main(String[] args) throws Exception {

        // Get token
        String token = ZohoAuth.getAccessToken();
    }
}