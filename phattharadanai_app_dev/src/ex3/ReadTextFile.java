package ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
	public static String[] readTextFile(String fileName) {
		System.out.println("in readTextFile(), filename:" + fileName);
		String[] lines = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			StringBuffer buf = new StringBuffer();
			while ((line = br.readLine()) !=null) {
				System.out.println(line);
				buf.append(line + "\n");
			}

			String temp = buf.toString();
			lines = temp.split("\n");
			br.close();
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}

}