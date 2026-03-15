package baekjoon_CT.bfs_dfs;
import java.util.*;
import java.io.*;

public class BOJ_1926 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int size = 0;
    static int maxValue = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1 ,0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    int area = bfs(i,j);
                    maxValue = Math.max(maxValue, area);
                    size++;
                }
            }
        }

        System.out.println(size);
        System.out.println(maxValue);

    }

    private static int bfs(int x, int y) {
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

                if(map[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    q.offer(new int[]{nextX, nextY});
                    count++;
                }
            }
        }

        return count;

    }
}
