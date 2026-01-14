package baekjoon_CT.backTracking;

import java.io.*;
import java.util.*;
/*
    다음에는 dx,dy를 (1,0) (0,1)로 방향 노드를 만들어서 풀어보면 좋을 것 같음.
* */
public class BOJ_31575 {
    static int N, M;
    static int[][] city;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];
        city = new int[M][N];

        // 도시 정보 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 백트랙킹으로 거래소 가는 길 탐색
        boolean result = backtracking(city, visited, 0, 0, M, N);

        if (result) System.out.println("Yes");
        else System.out.println("No");

    }

    private static boolean backtracking(int[][] city, boolean[][] visited, int x, int y, int m, int n) {
        // 범위를 벗어나거나 0 혹은 방문했던 곳이라면 false
        if( x<0 || y<0 || x >=m || y >=n || visited[x][y] || city[x][y]==0) return false;

        // 도착 지점이면 ( 종료 조건 ) true로 리턴
        if(x==M-1 && y==N-1) return true;

        visited[x][y] = true;
        // 가지치기
        if(backtracking(city, visited, x+1, y, m, n)) return true;
        if(backtracking(city, visited, x, y+1, m, n)) return true;
        // 다시 올라감 -> 이 문제에서는 단순 도착 여부만 이기 때문에 돌아가는 행위는 시간초과가 날수 있었다.
//        visited[x][y] = false;
        return false;

    }


}
