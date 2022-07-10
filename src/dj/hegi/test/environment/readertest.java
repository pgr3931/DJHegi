package dj.hegi.test.environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;



public class readertest {
	private String[] _lines;
	private String fileName;
	
	public readertest(String filename, int size) {
		fileName = filename;
		_lines = new String[size];
	}
	
	// einlesen
	
	public void read() {

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }  

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
		
	}
	
	public void export() {
		// The name of the file to open.
        String fileName = "newpl.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            int i = 0;
            while(i < _lines.length && _lines[i] != null) {
            bufferedWriter.write(_lines[i]);
            bufferedWriter.newLine();
            
            i++;
            }
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
	}

	
	public static void main(String[] args) {
		readertest test = new readertest("Testneu.txt", 30);
		test.read();
		System.out.println(Arrays.toString(test._lines));
		
		
	}
}
