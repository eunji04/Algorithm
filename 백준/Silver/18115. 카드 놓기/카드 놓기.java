import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb =new StringBuilder();
		int arr[] = new int[N];
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i=N-1;i>=0;i--) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<N;i++) {
			switch(arr[i]) {
				case 1:
					dq.offerFirst(i+1);
					break;
				case 2:
					int tmp = dq.pollFirst();
					dq.offerFirst(i+1);
					dq.offerFirst(tmp);
					break;
				case 3:
					dq.offerLast(i+1);
					break;
				
			}
		}
		
		for(int x : dq) {
			sb.append(x+" ");
		}
		System.out.println(sb);
		

	}

}
