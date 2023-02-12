package exercise3swingforms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFile {
	public static void writeTextFile(String fileName, String data, boolean Replace) {
		//System.out.println("WriteFileFor.main()");
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			if(data == null) {
				fw = new FileWriter(fileName, Replace);
			}
			else {
				fw = new FileWriter(fileName, Replace);
				bw = new BufferedWriter(fw);
				bw.write(data+"\n");
				bw.flush();
				bw.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
