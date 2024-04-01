import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[][] arr = new long[N][10];
		
		arr[0][0] = 0;
		for(int j=1; j<10; j++) {
			arr[0][j] = 1;
		}
		
		for(int i=1; i<N; i++) {
			
			arr[i][0] = arr[i-1][1];
			arr[i][9] = arr[i-1][8];
			
			for(int j=1; j<9; j++) {
				
				arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1])%1000000000;
				
			}
		}
		
		long ans = 0;
		for(int j=0; j<10; j++) {
			ans+=arr[N-1][j]%1000000000;
		}
		
		System.out.println(ans%1000000000);
	}

}
