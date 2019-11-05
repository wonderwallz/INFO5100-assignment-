package assignment7;

import java.io.*;
import java.util.*;

import javax.imageio.IIOException;

public class Reverse {
	
	public static void main(String[] args) throws  FileNotFoundException {
		File file = new File("/Users/wonde/Desktop/reverse");
		Scanner scanner;
		
		scanner = new Scanner(file);
		
			
		String reverse="";
		while(scanner.hasNextLine()) {
			String s = scanner.nextLine();
			System.out.println(s);
			
			String[] c = s.split(" ");
			for(int i=c.length-1;i>-1;i--) {
				reverse = reverse+c[i]+" ";
			}
		}
		
		System.out.print(reverse);
		
		scanner.close();
		
		
			try {
				File f = new File("/Users/wonde/Desktop/save.txt");
		        if(!f.exists()) {
				   f.createNewFile();
			    }
		        PrintWriter pw = new PrintWriter(f);
		        pw.println(reverse);
		        pw.close();
			}catch (IOException e) {
				
				e.printStackTrace();
			}
		
		
		
	}
}
