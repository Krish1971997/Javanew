package zoho;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class VideoDownloader {

    public static void main(String[] args) {
        String videoURL = "https://www.pornhub.org/view_video.php?viewkey=64c7d5ca87bb3"; // Direct video URL
        String savePath = "downloaded_video.mp4";

        try {
            downloadVideo(videoURL, savePath);
            System.out.println("Download Completed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void downloadVideo(String videoURL, String savePath) throws IOException {

        URL url = new URL(videoURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStream inputStream = connection.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(savePath);

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        outputStream.close();
        inputStream.close();
        connection.disconnect();
    }
}
