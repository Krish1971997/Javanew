package codetesting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PdfToImageConverter {

    public static void main(String[] args) {
        try {

            String inputPdf = "C:\\Users\\Admin\\Downloads\\Zoho_ISO9001WCAG_Certificate.pdf";
            String outputFile = "page-%d.png"; // Output pattern

            // Ghostscript command
            String[] command = {
                    "gs",
                    "-dNOPAUSE",
                    "-dBATCH",
                    "-sDEVICE=pngalpha",  // PNG output
                    "-r300",              // DPI (quality)
                    "-sOutputFile=" + outputFile,
                    inputPdf
            };

            Process process = Runtime.getRuntime().exec(command);

            // Capture error logs
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream())
            );

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();

            System.out.println("PDF successfully converted to images!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
