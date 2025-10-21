package baekjoon_CT.dynamic_programming;

import java.util.Scanner;

public class BOJ_11050 {

    private static int solution(int n, int k){
       if(k == 0 || n == k) return 1;

       return solution(n-1, k-1) + solution(n-1, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solution(N,K));
    }
}
