package baekjoon_CT.dynamic_programming;

import java.util.*;
import java.io.*;

public class BOJ_2533 {

    static int n = 0;
    static ArrayList<Integer>[] graph;
    static int[] p;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        n = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        p = new int[n + 1];
        dp = new int[n + 1][2];
        // dp[i][0]: i가 얼리어답터일 때, 서브트리의 최소 얼리어답터 수 (이 코드 로직에 맞게 재해석 필요)
        // 원본 코드의 주석 로직: (i,0) -> 자신을 칠하지 않았을 때(일반인일 때) 최댓값, (i,1) -> 자신을 칠했을 때(일반인일 때) 최댓값
        // 하지만 일반적인 2533 풀이(최소 얼리어답터 수 구하기)로 변환하는 것이 더 직관적일 수 있습니다.
        // 현재 코드는 "최대 독립 집합" 크기를 구해 전체에서 빼는 방식입니다.

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n - 1; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        // 전체 개수에서 '일반인일 수 있는 최대 사람 수'를 빼면 '최소 얼리어답터 수'가 됩니다.
        System.out.println(n - Math.max(dp[1][0], dp[1][1]));

        bf.close();
    }

    static void dfs(int cur) {
        dp[cur][0] = 0;
        dp[cur][1] = 1; // 1은 '일반인'으로 선택된 자기 자신을 의미

        for (int next : graph[cur]) {
            if (p[cur] == next) {
                continue;
            }

            p[next] = cur;
            dfs(next);

            // 내가 일반인이 아니라면(얼리어답터라면), 자식은 일반인이든 얼리어답터든 상관없이 더 많은 일반인을 가진 경우를 선택
            // (코드의 변수 의미가 일반적인 2533 풀이와 반대임에 유의: 여기선 1이 일반인 선택됨을 의미)
            dp[cur][0] += Math.max(dp[next][0], dp[next][1]);

            // 내가 일반인이라면, 내 친구(자식)는 무조건 얼리어답터여야 하므로 일반인으로 선택될 수 없음(dp[next][0])
            dp[cur][1] += dp[next][0];
        }
    }
}