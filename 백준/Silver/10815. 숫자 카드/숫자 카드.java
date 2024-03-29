import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int ans;
	
	static void search(int num, int start, int end) {
		
		if(start>end) return;
		
		int mid = (start+end)/2;
		int check = arr[mid];
		
		if(num == check) {
			ans = 1;
			return;
		}
		
		if(num<check) search(num, start, mid-1);
		else search(num, mid+1, end);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int k=0; k<M; k++) {
			ans = 0;
			search(Integer.parseInt(st.nextToken()), 0, N-1);
			System.out.print(ans+" ");
		}
		
	}

}
