package baekjoon_CT.bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ_4179 {
    static int R, C;
    static char[][] map;
    static int[][] fireTime;
    static int[][] jihoonTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireTime = new int[R][C];
        jihoonTime = new int[R][C];

        // 방문하지 않은 곳과 0초를 구분하기 위해 -1로 초기화
        for (int i = 0; i < R; i++) {
            Arrays.fill(fireTime[i], -1);
            Arrays.fill(jihoonTime[i], -1);
        }
        // BFS 사용.
        Queue<int[]> fireQ = new LinkedList<>();
        Queue<int[]> jihoonQ = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();

            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'F'){
                    fireQ.offer(new int[]{i, j});
                    fireTime[i][j] = 0; // 불 시작 시간 0
                }else if(map[i][j] == 'J'){
                    jihoonQ.offer(new int[]{i, j});
                    jihoonTime[i][j] = 0; // 지훈 시작 시간 0
                }
            }

        }
        // 불이 퍼지는 시간을 먼저 계산해야 지훈이가 피할 수 있음
        fire(fireQ);
        // 지훈이 이동
        jihoon(jihoonQ);

    }

    private static void jihoon(Queue<int[]> jihoonQ) {
        while (!jihoonQ.isEmpty()){
            int[] currnet = jihoonQ.poll();
            int curX = currnet[0];
            int curY = currnet[1];

            for (int i = 0 ; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 범위를 벗어나면 탈출!
                if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C){
                    System.out.println(jihoonTime[curX][curY]+1);
                    return;
                }
                // 이동 할 수 없는 경우 : 벽이거나 이미 방문했던 곳
                if(map[nextX][nextY] == '#' || jihoonTime[nextX][nextY] != -1) continue;
                // 불보다 늦거나 동시에 도착하면 이동 불가
                if(fireTime[nextX][nextY] != -1 && fireTime[nextX][nextY] <= jihoonTime[curX][curY]+1){
                    continue;
                }

                jihoonTime[nextX][nextY] = jihoonTime[curX][curY] + 1;
                jihoonQ.offer(new int[]{nextX, nextY});

            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static void fire(Queue<int[]> fireQ) {
        while (!fireQ.isEmpty()){
            int[] currnet = fireQ.poll();
            int curX = currnet[0];
            int curY = currnet[1];

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 범위 밖은 패스
                if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
                // 벽이거나 이미 불이 난 곳이면 패스
                if(map[nextX][nextY] == '#' || fireTime[nextX][nextY] != -1) continue;

                fireTime[nextX][nextY] = fireTime[curX][curY] + 1;
                fireQ.offer(new int[]{nextX, nextY});
            }
        }
    }
}
