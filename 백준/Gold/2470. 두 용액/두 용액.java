import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static int result;
	static int min, max;
	
	static void binarySearch(int minIndex, int maxIndex, int i) {
		
		if(minIndex>maxIndex) return;
		
		int mid = (minIndex+maxIndex)/2;
		int sum = arr[i]+arr[mid];
		
		if(Math.abs(sum)<result) {
			result = Math.abs(sum);
			min = arr[i];
			max = arr[mid];
		}
		
		if(sum<0) binarySearch(mid+1, maxIndex, i);
		else binarySearch(minIndex, mid-1, i);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		result = Integer.MAX_VALUE;
		min = 0; max = 0;
		
		for(int i=0; i<N-1; i++) {
			
			binarySearch(i+1, N-1, i);

		}
		
		System.out.println(min+" "+max);
		
	}
	
}
