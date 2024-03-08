package Boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1431 {
    static class Num implements Comparable<Num>{
        String s;
        int length;
        int sum;

        public Num(String s, int length, int sum){
            this.s =s;
            this.length =length;
            this.sum =sum;
        }

        @Override
        public int compareTo(Num o) {
            if(this.length - o.length <0){
                return -1;
            } else if(this.length == o.length){
                if(this.sum - o.sum <0){
                    return -1;
                } else if(this.sum - o.sum >0){
                    return 1;
                } else{
                    return this.s.compareTo(o.s);
                }
            } else{
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());

        Num[] arr =new Num[N];

        for(int i=0; i<N; i++){
            String s =br.readLine();
            int length =s.length();

            int sum =0;
            for(int k=0; k<length; k++){
                if(s.charAt(k)-'0'>=0 && s.charAt(k)-'0'<=9){
                    sum+=s.charAt(k)-'0';
                }
            }

            arr[i] =new Num(s, length, sum);

        }

        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            System.out.println(arr[i].s);
        }
    }
}
