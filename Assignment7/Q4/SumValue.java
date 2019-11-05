package assignment7;
import java.util.*;

public class SumValue {
	static long sum1 = 0;
	static long sum2 = 0;
	static long sum3 = 0;
	static long sum4 = 0;


	static void generateRandomArray(int[] arr) {
		Random r = new Random();
		for(int i=0;i<arr.length;i++) {
			arr[i] = r.nextInt();
		}
	}
	public static long sum(int[] arr) {
		Thread thread1 = new Thread() {
			public void get() {
			   sum1 = getSum(arr,0,1000000);
			}
		};
		Thread thread2 = new Thread() {
			public void get() {
				sum2 = getSum(arr,1000000,2000000);
			}
		};
		Thread thread3 = new Thread() {
			public void get() {
				sum3 = getSum(arr,2000000,3000000);
			}
		};
		Thread thread4 = new Thread() {
			public void get() {
				sum4 = getSum(arr,3000000,4000000);
			}

		};
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		return sum1+sum2+sum3+sum4;
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[4000000];
		generateRandomArray(arr);
		long sum = sum(arr);
		System.out.println("Sum: "+sum);
		
		
	}

}
