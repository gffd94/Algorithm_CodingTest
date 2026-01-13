package baekjoon_CT.graph;

import java.util.*;
import java.io.*;

public class BOJ_5241 {

    static int N, K, M;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 역의 수
        K = Integer.parseInt(st.nextToken()); // 튜브 연결의 수
        M = Integer.parseInt(st.nextToken()); // 튜브의 수

        // 노드 개수 : 역 (1~N) + 튜브 (N+1~N+M)
        adj = new ArrayList[N+M+1];
        for (int i = 1; i <= N+M; i++) {
            adj[i] = new ArrayList<>();
        }

        // 그래프 구성 ( 역 <-> 튜브 )
        for (int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int tubeNode = N + i; // 튜브를 하나의 노드로 생각 ( N+1부터 시작 )

            for (int j = 0; j < K; j++) {
                int station = Integer.parseInt(st.nextToken());
                // 양방향 연결 ( 1 -> 4[튜브] , 2 -> 4, 3 -> 4 , 4 -> 1,2,3 )
                adj[station].add(tubeNode);
                adj[tubeNode].add(station);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        if(N==1) return 1;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+M+1]; // 방문 체크
        q.offer(1); // 1번 역에서 시작
        visited[1] = true;

        int[] dist = new int[N+M+1]; // 거리 저장
        dist[1] = 1;

        while(!q.isEmpty()){
            int curr = q.poll();

            if( curr == N) {
                return dist[curr];
            }

            for(int next : adj[curr]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);

                    if(next > N) { // 다음 노드가 튜브라면
                        dist[next] = dist[curr]; // 카운트 올리지 않음
                    }else { // 다음 노드가 역이라면
                        dist[next] = dist[curr] + 1; // 방문 역 개수 증가
                    }
                }
            }
        }

        return -1;
    }
}
