package assignment5;

import java.util.Scanner;
import java.util.Random;

public class MyIndexOutOfBoundException extends RuntimeException {
	int lowerBound;
	int upperBound;
	int index;
	
	MyIndexOutOfBoundException(int lowerBound, int upperBound, int index){
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.index = index;
	}
	
	public String toString() {
		return "Error Message: Index: "+this.index+", but Lower bound: "+this.lowerBound
				+", Upper bound: "+this.upperBound;
	}
	

	public static void main(String[] args) {
		int size = 100;
		int[] a = new int[100];
		Random r = new Random();
		int i = r.nextInt(200);
		System.out.println("Random access within array size of 100");
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the index: "+i);
			if(i>=size) {
				throw new MyIndexOutOfBoundException(0,size-1,i);
			}
		}
		catch(RuntimeException ex) {
			System.out.println(ex);
			return;
		}

	}

}
