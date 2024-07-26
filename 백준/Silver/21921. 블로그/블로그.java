import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] daily = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            daily[i] = Integer.parseInt(st.nextToken());
        }

        long cnt = 0;
        for(int i=0; i<X; i++){
            cnt +=daily[i];
        }

        long ansMaxVisit = cnt;
        int ansCnt = 1;

        int startIndx = 0;
        int endIndx = X-1;

        while (endIndx+1 < N){

            endIndx++;

            cnt -=daily[startIndx];
            cnt +=daily[endIndx];

            startIndx++;

            if(cnt == ansMaxVisit){
                ansCnt +=1;
            } else if(cnt > ansMaxVisit){
                ansCnt = 1;
                ansMaxVisit = cnt;
            }

        }

        if(ansMaxVisit == 0) System.out.println("SAD");
        else {
            System.out.println(ansMaxVisit);
            System.out.println(ansCnt);
        }

    }

}
