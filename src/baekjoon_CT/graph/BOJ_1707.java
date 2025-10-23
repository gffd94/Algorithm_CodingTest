package baekjoon_CT.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1707 {

    static ArrayList<Integer>[] graph;
    static int[] check;
    static boolean[] visit;
    static boolean IsEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            String[] str = br.readLine().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
            graph = new ArrayList[V+1];
            check = new int[V+1];
            visit = new boolean[V+1];
            IsEven = true;

            // 인접 리스트 초기화하기
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            // 에지 데이터 저장하기
            for (int i = 0; i < E; i++) {
                str = br.readLine().split(" ");
                int start = Integer.parseInt(str[0]);
                int end = Integer.parseInt(str[1]);
                // 방향이 정해져 있지 않으므로 둘다 넣어줌
                graph[start].add(end);
                graph[end].add(start);
            }

            // 모든 노드에서 DFS를 실행 해야함
            for (int i = 1; i <= V; i++) {
                if (IsEven) {
                    DFS(i);
                }else {
                    break;
                }
            }

            if(IsEven) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }
    }

    private static void DFS(int start) {
        visit[start] = true;
        // 인접리스트에서 받아서 start 노드에서 연결되어 있는 모든노드를 탐색
        for (int i : graph[start]) {
            if (!visit[i]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요!
                check[i] = (check[start] + 1) % 2;
                DFS(i);
            }else if( check[start] == check[i]) {
                IsEven = false;
            }
        }
    }
}
