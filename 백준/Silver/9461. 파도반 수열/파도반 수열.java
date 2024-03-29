import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		long[] arr = new long[101];
		arr[1] =1; arr[2]=1; arr[3]=1; arr[4]=2; arr[5]=2; arr[6]=3; arr[7]=4; arr[8]=5;
		for(int i=9; i<=100; i++) {
			arr[i] = arr[i-1]+arr[i-5];
		}
		
		for(int i=0; i<tc; i++) {
			int n = sc.nextInt();
			System.out.println(arr[n]);
		}
		
	}

}