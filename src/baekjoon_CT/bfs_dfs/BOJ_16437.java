package baekjoon_CT.bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ_16437 {
    static int N;
    static ArrayList<Integer>[] tree;
    static long[] info; // 양(+), 늑대(-)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        info = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0);
            int amount = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());

            // 핵심 1: 탐색을 위해 부모 -> 자식 방향으로 저장
            tree[parent].add(i);

            // 늑대는 음수로 저장하여 뺄셈 로직 간소화
            if (type == 'S') info[i] = amount;
            else info[i] = -amount;
        }

        // 1번 섬부터 탐색 시작
        System.out.println(dfs(1));
    }

    // 핵심 2: 후위 순회 (자식들의 결과를 모아서 처리)
    static long dfs(int current) {
        long sum = 0;

        // 자식 노드들 먼저 탐색
        for (int child : tree[current]) {
            sum += dfs(child);
        }

        // 현재 노드 처리
        sum += info[current];

        // 늑대가 양보다 많으면 0마리 생존
        if (sum < 0) return 0;
        else return sum;
    }
}
