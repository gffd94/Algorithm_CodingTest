package baekjoon_CT.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] dp , sticker;

        // 테스트 케이스 진행
        for (int i = 0; i < N; i++) {

            int M = Integer.parseInt(br.readLine());
            dp = new int[3][M];
            sticker = new int[2][M];

            // 스티커 점수값 저장
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // dp 초기값 0,0
            dp[1][0] = sticker[0][0];
            dp[2][0] = sticker[1][0];

            // dp 값 점화식 저장
            for (int j = 1; j < M; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[2][j-1]);
                dp[1][j] = Math.max(dp[0][j-1], dp[2][j-1]) + sticker[0][j];
                dp[2][j] = Math.max(dp[0][j-1], dp[1][j-1]) + sticker[1][j];
            }

            System.out.println(Math.max(dp[0][M-1], Math.max(dp[1][M-1], dp[2][M-1])));
        }
    }
}
