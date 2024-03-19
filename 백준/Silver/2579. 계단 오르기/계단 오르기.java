import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        int[] stair =new int[N];
        for(int i=0; i<N; i++){
            stair[i] =Integer.parseInt(br.readLine());
        }

        int[] yes1 =new int[N];
        int[] yes2 =new int[N];
        int[] no =new int[N];

        yes1[0] =stair[0];
        yes2[0] =0; no[0] =0;

        for(int i=1; i<N; i++){
            yes1[i] =no[i-1]+stair[i];
            yes2[i] =yes1[i-1]+stair[i];
            no[i] =Math.max(yes2[i-1],yes1[i-1]);
        }

        System.out.println(Math.max(yes1[N-1],yes2[N-1]));
    }
}