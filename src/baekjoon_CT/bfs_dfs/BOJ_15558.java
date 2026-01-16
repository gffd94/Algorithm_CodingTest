package baekjoon_CT.bfs_dfs;

import java.util.*;
import java.io.*;

public class BOJ_15558 {
    static int N, K;
    static int[][] map; // 2줄짜리 맵 (0: 왼쪽 , 1:오른쪽)
    static boolean[][] visited; // 방문 체크

    static class Node{
        int line; // 0 or 1
        int index; // 현재위치
        int time;

        public Node(int line, int index, int time){
            this.line = line;
            this.index = index;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[2][N];
        visited = new boolean[2][N];

        String line1 = br.readLine();
        String line2 = br.readLine();

        for(int i = 0; i < N; i++){
            map[0][i] = line1.charAt(i) - '0'; // 문자를 숫자로 변환
            map[1][i] = line2.charAt(i) - '0';
        }

        System.out.println(jump());
    }

    private static int jump() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0)); // 시작점 = 왼쪽줄, 인덱스 0, 시간 0초
        visited[0][0] = true;

        while (!q.isEmpty()){
            Node current = q.poll();

            for (int i = 0; i < 3; i++){
                // 3가지 이동 경우의 수 ( 전진 후진 대각선 )
                int nextLine = current.line;
                int nextIndex = current.index;
                int nextTime = current.time + 1;

                if(i == 0) {
                    nextIndex += 1; // 한칸전진
                }else if (i == 1) {
                    nextIndex -= 1; // 한칸후진
                }else {
                    nextLine = 1 - current.line; // 줄 변경
                    nextIndex += K;
                }

                // 1. [탈출성공]
                if (nextIndex >= N) return 1;

                // 2. [유효성검사]
                // 바닥이 사라진 경우
                if (nextIndex <= current.time) continue;

                // 전진한 칸이 1 + 방문 안한 곳
                if (!visited[nextLine][nextIndex] && map[nextLine][nextIndex] == 1) {
                    visited[nextLine][nextIndex] = true;
                    q.offer(new Node(nextLine, nextIndex, nextTime));
                }
            }
        }


        return 0;
    }
}
