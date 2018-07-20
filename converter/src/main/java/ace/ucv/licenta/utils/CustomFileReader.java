package ace.ucv.licenta.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CustomFileReader {

	private FileReader fileReader;
	private BufferedReader bufferReader;

	public CustomFileReader(String filename) throws FileNotFoundException {
		fileReader = new FileReader(filename);
		bufferReader = new BufferedReader(fileReader);
	}

	public String getContent() throws IOException {
		String content = null;
		String currentLine = null;

		while ((currentLine = bufferReader.readLine()) != null) {
			if (content == null) {
				content = currentLine;
			} else {
				content += currentLine;
			}
		}

		return content;
	}

	public void close() throws IOException {
		fileReader.close();
		bufferReader.close();
	}
}
