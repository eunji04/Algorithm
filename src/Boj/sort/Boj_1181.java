package Boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Boj_1181 {

    static class word implements Comparable<word>{
        int length; String s;
        public word(int length, String s){
            this.length =length;
            this.s =s;
        }

        @Override
        public int compareTo(word o) {
            if(this.length - o.length <0){
                return -1;
            } else if(this.length - o.length >0){
                return 1;
            } else {
                return this.s.compareTo(o.s);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        word[] arr =new word[N];
        for(int i=0; i<N; i++){
            String s =br.readLine();
            int len =s.length();
            arr[i] =new word(len,s);
        }

        Arrays.sort(arr);

        List<String> list =new ArrayList<>();

        for(int i=0; i<N; i++){
            String x =arr[i].s;
            if(!list.contains(x)) list.add(x);
        }

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
