import java.util.*;
import java.io.*;

public class Main {

    static int N, HP, umbrella;
    static char[][] maps;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0 ,1, 0, -1};
    static int[][] visited;
    static int[] start = {0,0};
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        HP = Integer.parseInt(st.nextToken());
        umbrella = Integer.parseInt(st.nextToken());

        maps = new char[N][N];
        visited = new int[N][N];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                maps[i][j] = line.charAt(j);
                if(maps[i][j] == 'S') start = new int[]{i, j};
            }
        }

        // bfs 탐색
        int result = bfs(start);

        System.out.println(result);
        
    }

    private static int bfs(int[] start){
        Queue<int[]> queue = new LinkedList<>();
        // x , y , 내구도, 체력, 이동횟수
        queue.offer(new int[]{start[0], start[1], 0, HP, 0});
        visited[start[0]][start[1]] = HP;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int currentD = current[2];
            int currentHP = current[3];
            int currentCount = current[4];

            for(int i = 0; i < 4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if( nx < 0 || ny < 0 || nx >= N || ny >= N){
                    continue;
                }

                int nextD = currentD;
                int nextHP = currentHP;
                                     
                // E를 만난 경우 (즉시 종료 가능)
                if(maps[nx][ny] == 'E'){
                    return currentCount+1;
                }

                // U를 만난 경우
                if(maps[nx][ny] == 'U'){
                    nextD = umbrella;
                }

                // 우산이 있는 경우
                if(nextD > 0){
                    nextD--;
                } else{ // 우산이 없는 경우
                    nextHP--;
                }

                // HP가 0이면 버림
                if(nextHP <= 0) continue;
                    
                // 기존 visited 보다 상태가 더 좋을 때만 이동
                int nextState = nextD + nextHP;
                if(visited[nx][ny] < nextState){
                    visited[nx][ny] = nextState;    
                    queue.offer(new int[]{nx, ny, nextD, nextHP, currentCount + 1});
                }
                
            }
        }

        return -1;


    }


}