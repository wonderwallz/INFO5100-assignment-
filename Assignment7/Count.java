package assignment7;
import java.io.*;

public class Count {
	public static void lineCount(String fileName) {
		int numOfLine=0;
		BufferedReader br;
		
		
		try {
			 br = new BufferedReader(new FileReader(fileName));
		}catch(Exception ex) {
			System.out.println("Cannot open the file.");
			return;
		}
		
		try {
			String line = br.readLine();
			while(line!=null) {
				numOfLine++;
				line = br.readLine();
			}
		}catch(Exception ex) {
			System.out.println("Cannot read from the file.");
			return;
		}
		System.out.println("The number of lines-> "+ numOfLine);
		
	}

	public static void main(String[] args) {
		for(int i=0;i<args.length;i++) {
			System.out.print(args[i]+": ");
			lineCount(args[i]);
		}

	}

}
