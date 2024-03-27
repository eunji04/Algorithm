import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n==1) System.out.println(1);
		else {
			long[] cnt0 = new long[n+1];
			long[] cnt1 = new long[n+1];
			
			cnt0[1]=0; cnt1[1]=1;
			for(int i=2; i<=n; i++) {
				cnt0[i] = cnt0[i-1]+cnt1[i-1];
				cnt1[i] = cnt0[i-1];
			}
			
			System.out.println(cnt0[n]+cnt1[n]);
		}
		
	}

}
