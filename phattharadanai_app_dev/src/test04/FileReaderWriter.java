package test04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileReaderWriter {
	
    public void writeFile(String fName) {
    	
		String fileName = "Data-Written-For-Test04.txt";
		fileName = fName;
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
	        Date today = new Date();
	        SimpleDateFormat formatter =
	           new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
	        String dateString = formatter.format(today);

			
			bw = new BufferedWriter(new FileWriter(fileName));
			bw.write("Data-Written-For-Test04.txt:" + dateString);
			bw.close();
        } catch (IllegalArgumentException iae) {
            System.err.println("Error: " + iae.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();
		}

    	
    }
    
    public void readFile(String fName) {
    	
		String fileName = "files/StudentMarks.txt";
		fileName = fName;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    }

}
