import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		
		int sum = 0;
		int len = 0;
		int result = Integer.MAX_VALUE;
		
		while(true) {
			
			if(sum >= S) {
				
					result = Math.min(len, result);
				
				sum-=arr[start];
				start+=1;
				len-=1;
			} else if(end == N) {
				break;
			} else if(sum < S) {
				sum+=arr[end];
				end+=1;
				len+=1;
			}
			
//			System.out.println("start: "+start+" end: "+end+" sum: "+sum+" len: "+len);
			
		}
		
		if(result != Integer.MAX_VALUE) System.out.println(result);
		else System.out.println(0);
	}

}
