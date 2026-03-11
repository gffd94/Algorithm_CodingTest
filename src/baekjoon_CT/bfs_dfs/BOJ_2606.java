package baekjoon_CT.bfs_dfs;

import java.util.*;
import java.io.*;

public class BOJ_2606 {

    static ArrayList<Integer>[] graph;
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];

        // 그래프 초기화
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }


        // graph 인접리스트 형태로 입력값 저장 graph(1) -> [2, 5]
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 방문 체크 ( 중복방지 )
        visited = new boolean[N+1];

        int answer = bfs(1);

        System.out.println(answer);

    }

    static int bfs(int current){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(current);
        visited[current] = true;
        int count = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}
