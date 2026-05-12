import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int MODNUM = 1_000_000_003;
        int answer = 0;

        // 1. 예외 처리: 고르려는 개수가 전체의 절반을 초과하면 0 출력
        if (K > N / 2) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[N + 1][K + 1];

        // 2. 초기값 세팅 (Base Case)
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1; // i개 중에 0개를 고른 경우
            dp[i][1] = i; // i개 중에 1개를 고른 경우 
        }

        // 3. 선형 DP 점화식 계산 (일직선일 때의 정답 창고 만들기)
        for (int i = 3; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                // i를 고르지 않는 경우 + i를 고르는 경우
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MODNUM;
            }
        }

        // 4. 원형 조건을 고려하여 최종 정답 도출
        // N번째를 고르지 않은 경우 + N번째를 고른 경우
        answer = (dp[N - 1][K] + dp[N - 3][K - 1]) % MODNUM;

        System.out.println(answer);
    } 
}