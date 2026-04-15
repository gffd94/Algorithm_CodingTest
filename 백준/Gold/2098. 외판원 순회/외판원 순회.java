import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] W;
    static int[][] dp;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][1 << N]; // dp[현재도시][방문상태]

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 전체 INF로 초기화
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }

        System.out.println(tsp(0,1));
    }

    static int tsp(int current, int visited) {
        //종료 조건 : 모든 도시를 방문 했으면 출발지로 복귀
        if(visited == (1 << N) -1) {
            return W[current][0] == 0 ? INF : W[current][0];
        }

        // 이미 계산한 값 있으면 재사용
        if(dp[current][visited] != -1) {
            return dp[current][visited];
        }

        dp[current][visited] = INF;

        // 아직 방문안한 도시로 이동
        for(int next = 0; next < N; next++) {
            // 조건 : 방문 안했고 + 연결된 도시
            if((visited & (1 << next)) == 0 && W[current][next] != 0) {

                int cost = tsp(next, visited | (1 << next));
                if(cost != INF) {
                    dp[current][visited] = Math.min(dp[current][visited] , cost + W[current][next]);
                }

            }
        }

        return dp[current][visited];
    }
}