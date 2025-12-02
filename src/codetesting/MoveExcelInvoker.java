package codetesting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MoveExcelInvoker {
	public static void main(String[] args) {
		String batFilePath = "C:\\Users\\Admin\\Music\\Bat files\\move_excel.bat"; // Or full path like
																					// "C:\\path\\to\\move_excel.bat"
		ProcessBuilder pb = new ProcessBuilder(Arrays.asList(batFilePath));
		try {
			// Start the process
			Process process = pb.start();

			// Read output (stdout) from the batch file
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line); // Prints batch echoes like "Moving Excel file..." and success/error messages
			}

			// Read errors (stderr) if any (e.g., command not found)
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while ((line = errorReader.readLine()) != null) {
				System.err.println("Error: " + line);
			}

			// Wait for the process to complete and check exit code
			int exitCode = process.waitFor();
			if (exitCode == 0) {
				System.out.println("Batch file executed successfully! (File move completed)");
			} else {
				System.out.println("Batch file failed with exit code: " + exitCode);
			}

		} catch (IOException | InterruptedException e) {
			System.err.println("Exception occurred while running batch file: " + e.getMessage());
			e.printStackTrace();
		}
	}
}