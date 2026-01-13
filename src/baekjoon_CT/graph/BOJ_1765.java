package baekjoon_CT.graph;

import java.io.*;
import java.util.*;

public class BOJ_1765 {

    static int N, M;
    static ArrayList<Integer>[] friendGraph;
    static ArrayList<Integer>[] enemyGraph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //그래프 초기화
        friendGraph = new ArrayList[N+1];
        enemyGraph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            friendGraph[i] = new ArrayList<>();
            enemyGraph[i] = new ArrayList<>();
        }

        //1. 입력받아서 친구/원수 리스트 저장
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (type == 'F'){
                friendGraph[u].add(v);
                friendGraph[v].add(u);
            }else {
                enemyGraph[u].add(v);
                enemyGraph[v].add(u);
            }
        }

        // 원수의 원수는 친구다 -> friendGraph에 추가
        for (int i = 1; i <= N; i++) {
            for (int enemy : enemyGraph[i]) { // 나의 원수들을 찾음
                for (int enemyOfEnemy : enemyGraph[enemy]) { // 그 원수의 원수를 찾음
                    if(i == enemyOfEnemy) continue; // 자기 자신은 제외, i와 enemyOfEnemy는 친구 관계가 성립
                    friendGraph[i].add(enemyOfEnemy);
                    friendGraph[enemyOfEnemy].add(i);
                }
            }
        }

        // BFS를 이용해 연결 요소 개수 세기
        visited = new boolean[N+1];
        int teamCount = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]){
                teamCount++; // 새로운 팀 발견
                bfs(i); // 연결된 모든 사람 방문처리
            }
        }

        System.out.println(teamCount);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()){
            int curr = q.poll();
            for (int next : friendGraph[curr]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
