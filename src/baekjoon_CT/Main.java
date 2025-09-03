package baekjoon_CT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /* 1421 문제
    * */
    static int[] arr;
    static int n,c,w,max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new  StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 나무 갯수
        c = Integer.parseInt(st.nextToken()); // 나무 절단 비용
        w = Integer.parseInt(st.nextToken()); // 자른 나무 당 비용

        max = Integer.MIN_VALUE; // 나무 길이 중 가장 긴 나무 길이 값

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());

        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println(solution(arr));
    }

    private static long solution(int[] arr) {
        long sum = 0, price = 0, count = 0;
        long maxSum = Long.MIN_VALUE;

        for (int i = 1; i <= max; i++) { // 1~ 최대 나무 길이 까지 중 가장 최대 이익 게산
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                count = 0;
               if(arr[j]>=i){
                   if(arr[j]%i == 0) {
                       count = arr[j]/i -1 ;
                   }else {
                       count = arr[j]/i;
                   }
                   price = ((arr[j]/i)*w*i - (count*c));
                   if (price > 0) sum += price;
               }
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
