package baekjoon_CT.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2533 {

    // 그래프(트리) 인접 리스트
    static ArrayList<Integer>[] graph;
    // dp[node][0] : node가 얼리어답터가 아닐 때, 서브트리 최소 얼리어답터 수
    // dp[node][1] : node가 얼리어답터일 때, 서브트리 최소 얼리어답터 수
    static int[][] dp;
    // 방문 체크 (부모-자식 방향 확정용)
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람(정점) 수

        // 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 친구 관계 (트리의 간선) 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 무방향(양방향) 그래프
            graph[a].add(b);
            graph[b].add(a);
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        // 트리의 루트를 1번 노드로 가정하고 DFS 시작
        dfs(1);

        // 루트(1번)가 얼리어답터가 아닐 때 / 일 때 중 더 작은 값이 정답
        int answer = Math.min(dp[1][0], dp[1][1]);
        System.out.println(answer);
    }


    static void dfs(int cur) {
        visited[cur] = true;

        // 현재 노드를 얼리어답터로 선택하는 경우
        dp[cur][1] = 1;  // 자기 자신(얼리어답터)이므로 1부터 시작
        dp[cur][0] = 0;  // 얼리어답터가 아닌 경우는 일단 0으로 시작

        // 자식(인접) 노드 순회
        for (int next : graph[cur]) {
            if (!visited[next]) {
                // 자식 노드 먼저 처리 (후위 순회)
                dfs(next);

                // 1) cur이 얼리어답터가 아닐 때 (dp[cur][0])
                //    → 자식은 반드시 얼리어답터여야 조건을 만족
                //    → 자식의 상태는 [1]만 허용
                dp[cur][0] += dp[next][1];

                // 2) cur이 얼리어답터일 때 (dp[cur][1])
                //    → 자식은 얼리어답터일 수도 있고, 아닐 수도 있음
                //    → 둘 중 더 적은 얼리어답터 수를 가지는 경우 선택
                dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}