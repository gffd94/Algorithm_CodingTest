package baekjoon_CT.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15486 {

    static int[] dp;
    static int[][] schedules;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        schedules = new int[N+1][2];

        // 상담 정보 데이터 초기화
        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split(" ");
            schedules[i][0] = Integer.parseInt(str[0]); // 소요일
            schedules[i][1] = Integer.parseInt(str[1]); // 금액
        }

        // DP ( 최대 비용 ) 연산
        for (int i = 1; i <= N; i++) {
            int times = schedules[i][0];
            int cost = schedules[i][1];

            // 오늘 상담을 할 수 있다면 ( 퇴사 전 )
            if (i + times - 1 <= N ){
                dp[i + times - 1] = Math.max(dp[i + times - 1], dp[i - 1] + cost);
            }

            // 오늘 까지 최대 누적금액 정산
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[N]);
    }
}
