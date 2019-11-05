package assignment7;

public class Run extends Thread {
	public int[] arr;
	private int begin;
	private int end;
	
	public Run(int[] arr) {
		this.arr = arr;
	}
	
	public static void getSum(int[]arr, int start, int end) {
		long sum = 0;
		for(int i=start;i<end;i++) {
			sum = sum + arr[i];
		}
	}

}
