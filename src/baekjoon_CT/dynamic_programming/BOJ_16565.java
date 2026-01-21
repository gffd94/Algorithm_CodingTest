package baekjoon_CT.dynamic_programming;

import java.io.*;

public class BOJ_16565 {
    static final int MOD = 10007;
    static int[][] comb = new int[53][53];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 조합 (nCr) 미리 계산해두기
        for (int i = 0; i < 53; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                // 컴퓨터에 저장할 수 있게 MOD(모듈러 계산)
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        int answer = 0;

        // k = 포카드 세트의 개수
        for (int k = 1; k * 4 <= N; k++) {

            // 항계산 : 13Ck * (52-4k)C(N-4k)
            int temp = (comb[13][k] * comb[52 - 4*k][N - 4*k]) % MOD;

            if(k % 2 == 1) {
                // 홀수번째 항 : 더하기
                answer = (answer + temp) % MOD;
            }else {
                // 짝수번째 항 : 빼기
                // +MOD 를 해주는 이유는 음수가 나올 수 있는데 자바 int형은 음수를 담을 수 없음.
                answer = (answer - temp + MOD) % MOD;
            }
        }

        System.out.println(answer);
    }
}
