package Boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_11652 {
    static class Num implements Comparable<Num>{
        long n;
        public Num(long n){
            this.n =n;
        }

        @Override
        public int compareTo(Num o) {
            return (int) (this.n - o.n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());

        Num[] arr =new Num[N];
        for(int i=0; i<N; i++){
            long n =Integer.parseInt(br.readLine());
            arr[i] =new Num(n);
        }

        Arrays.sort(arr);


        int max =0; int cnt =0; int ans =0;
        for(int i=0; i<N-1; i++){
            if(arr[i].n == arr[i+1].n) {
                cnt+=1;
            }
            else{
                if(cnt>max) {
                    max =cnt;
                    ans = (int) arr[i].n;
                }
                cnt =0;
            }
        }
        System.out.println(ans);
    }
}
