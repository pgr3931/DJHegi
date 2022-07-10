package dj.hegi.test.environment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class containstest {
	private String _filename;
	private String[] _lines;
	

	public containstest(String filename, int size) {
		_filename = filename;
		_lines = new String[size];
	}

	// einlesen
	public void read() {

		String line = null;

		try {

			FileReader fileReader = new FileReader(_filename);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			int i = 0;
			while ((line = bufferedReader.readLine()) != null && i < 150) {
				_lines[i] = line;
				i++;
			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + _filename + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + _filename + "'");

		}

	}

	public static void main(String[] args) {
		containstest test = new containstest("Paschanga 4.m3u8", 400);
		test.read();
		System.out.println(Arrays.toString(test._lines));
		if ((test._lines[3].contains("Remix") == true) && test._lines[2].contains("F#m") == false) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		//System.out.println(test._lines[3].charAt(test._lines[3].length() - 9));
		/*
		System.out.println(test._lines[2].charAt(test._lines[2].length()-1));
		System.out.println(test._lines[2]);
		if ((test._lines[2].contains("F") == true) && test._lines[2].contains("F#m") == false) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}*/
	}
}
