package baekjoon_CT.bfs_dfs;

import java.util.*;
import java.io.*;

public class BOJ_12761 {

    static int A, B, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 방문 여부 체크
        boolean[] visited = new boolean[100001];
        // 거리 저장용 배열
        int[] distance = new int[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N); // 시작점
        visited[N] = true;

        while(!queue.isEmpty()){
            int curr = queue.poll();

            // 현재 위치가 목적지면 종료
            if(curr == M){
                System.out.println(distance[curr]);
                return;
            }
            // 진행하는 방법 8가지 저장
            int[] next = {curr+1, curr-1, curr+A, curr-A, curr+B, curr-B, curr*A, curr*B};

            for(int nextNum : next){
                // 범위 안에 있고 , 아직 방문하지 않는 위치 인 경우 실행
                if(nextNum >= 0 && nextNum <= 100000 && visited[nextNum] == false){
                    visited[nextNum] = true;
                    distance[nextNum] = distance[curr] + 1; // 이동 횟수 +1
                    queue.offer(nextNum);
                }
            }

        }



    }
}
