package Boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuffer sb;

        int N =Integer.parseInt(st.nextToken());
        long[] arr =new long[N];
        int index =0;

        while (index<N){
            if(st.countTokens() !=0){
                String s = st.nextToken();
                sb =new StringBuffer(s);
                long n = Long.parseLong(sb.reverse().toString());

                arr[index++] =n;
            } else{
                st =new StringTokenizer(br.readLine());
            }
        }

        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            System.out.println(arr[i]);
        }

    }
}
