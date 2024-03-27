import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] LIS = new int[N];
		
		for(int i=0; i<N; i++) {
			LIS[i] = 1;
			for(int j=0; j<i; j++) {
				if(A[j]<A[i] && LIS[i]<LIS[j]+1) {
					LIS[i] = LIS[j]+1;
				}
			}
			
		}
		
		int max =0;
		for(int k=0; k<N; k++) {
			if(max<LIS[k]) max=LIS[k];
		}
		
		System.out.println(max);
		
	}

}
