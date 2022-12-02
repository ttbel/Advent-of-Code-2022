package pl.larks.aoc22.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public static void printInputStream(InputStream is) {

		try (var streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
				var reader = new BufferedReader(streamReader)) {

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> loadInputStreamToList(InputStream is) {

		List<String> list = new ArrayList<>();
		try (var streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
				var reader = new BufferedReader(streamReader)) {

			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public InputStream getFileFromResourceAsStream(String fileName) {

		var classLoader = getClass().getClassLoader();
		var inputStream = classLoader.getResourceAsStream(fileName);

		if (inputStream == null) {
			throw new IllegalArgumentException("file not found! " + fileName);
		} else {
			return inputStream;
		}
	}

	public List<String> loadFileToList(String fileName) {

		final InputStream fileFromResourceAsStream = getFileFromResourceAsStream(fileName);
		return loadInputStreamToList(fileFromResourceAsStream);
	}

	public void printInputStream(String fileName) {
		final InputStream fileFromResourceAsStream = getFileFromResourceAsStream(fileName);
		printInputStream(fileFromResourceAsStream);
	}
}
