import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int minIndex = 0;
		int maxIndex = N-1;
		
		int min = 0;
		int max = 0;
		
		int result = Integer.MAX_VALUE;
		
		while(minIndex < maxIndex) {
			
			int sum = arr[minIndex] + arr[maxIndex];
			
			if(sum == 0) {
				min = arr[minIndex];
				max = arr[maxIndex];
				break;
			}
			
			if(sum>0) {
				
				if(sum<result) {
					result = sum;
					min = arr[minIndex];
					max = arr[maxIndex];
				}
				
				maxIndex-=1;
				
			} else if(sum<0) {
				
				if(Math.abs(sum)<result) {
					result = Math.abs(sum);
					min = arr[minIndex];
					max = arr[maxIndex];
				}
				
				minIndex+=1;
			}
			
		}
		
		System.out.println(min+" "+max);
	}
	
}
