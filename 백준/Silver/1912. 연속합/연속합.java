import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sum = new int[n];
		sum[0] = arr[0];
		
		for(int i=1; i<n; i++) {
			sum[i] = Math.max(sum[i-1]+arr[i], arr[i]);
		}
		
		int max =Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			if(max<sum[i]) max=sum[i];
		}
		System.out.println(max);
	}

}
