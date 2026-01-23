package baekjoon_CT.dynamic_programming;

import java.io.*;
import java.util.*;

public class BOJ_13910 {
    static int N, M;
    static int[] size;
    static int[] dp;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        size = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        // 한 번에 요리할 수 있는 모든 경우의 수 구해둠 (Set 사용)
        HashSet<Integer> cooking = new HashSet<>();

        // 1. 1개만 사용
        for (int i = 0; i < M; i++) {
            cooking.add(size[i]);
        }

        // 2. 2개 사용 (양손잡이)
        for (int i = 0; i < M; i++) {
            for (int j = i+1; j < M; j++) {
                cooking.add(size[i] + size[j]);
            }
        }
        // DP 실행
        solve(N, cooking);
    }

    private static void solve(int order, HashSet<Integer> cooking) {
        dp = new int[order+1];
        Arrays.fill(dp, INF); // 최솟값을 구해야 하므로 큰 값을 애초에 초기화
        dp[0] = 0; // 0인분 0번 요리 (시작)

        // DP : i인분을 만들기 위해 (i-용량)인분 상태에서 1번 더 요리
        for (int i = 1; i <= order; i++) {
            for (int cap : cooking) {
                // 현재 만들려는 i양 보다 cap 용량이 작거나 같아야함.
                // 이전 상태(i-cap)가 만들 수 있는 상태여야 함.
                if(i >= cap && dp[i-cap] != INF) {
                    dp[i] = Math.min(dp[i], dp[i-cap] + 1);
                }
            }
        }

        if(dp[order] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[order]);
        }
    }


}
