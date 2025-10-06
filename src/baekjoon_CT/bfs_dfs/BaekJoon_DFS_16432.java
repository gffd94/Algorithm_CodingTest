package baekjoon_CT.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_DFS_16432 {
    static int N;
    static List<Integer>[] cake; // 각 날의 떡 후보
    static boolean[][] visited; // [day][prev]로 성공/실패 방문여부 확인
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        cake = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            cake[i] = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                cake[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        visited = new boolean[N+2][10]; // 종료시점 까지 N+2, 떡 번호 1~9
        check = new int[N+1];

        if(dfs(1,0)) {
            StringBuilder sb= new StringBuilder();
            for (int i = 1; i <= N; i++) {
                sb.append(check[i]).append("\n");
            }
            System.out.print(sb);
        }else  {
            System.out.println(-1);
        }

    }

    static boolean dfs(int day, int prev) {
        if(day == N + 1) return true;
        if(visited[day][prev]) return false; // 이 상태는 한번 방문한적 있다 -> false
        visited[day][prev] = true;

        for(int x: cake[day]) {
            if(x == prev) continue; // 전 날과 같은 떡은 금지
            check[day] = x; // 오늘은 x번 떡 선택
            if(dfs(day+1, x)) return true; // 내일로 진행 성공시 전파

        }

        return false; // 여기까지 오면 조합 실패
    }
}
