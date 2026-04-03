import java.util.*;
import java.io.*;

public class Main {
 
    static int M, N;
    static boolean[][] visited;
    static int[][] square;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int depth, sum, answer;

    static int[][][] Tshape = {
        {{0,0}, {1,0}, {-1,0}, {0,1}},
        {{0,0}, {1,0}, {-1,0}, {0,-1}},
        {{0,0}, {0,1}, {0,-1}, {1,0}},
        {{0,0}, {0,1}, {0,-1}, {-1,0}}
    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        square = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                // dfs 탐색 (x, y, depth, sum)
                dfs(i,j,1,square[i][j]);
                visited[i][j] = false;
                // ㅜ 모양 따로 탐색
                tShapeSearch(i, j);
            }
        }
        
   
        
        System.out.println(answer);
    }


    // ㄴ,ㄹ,ㅁ,ㅣ (방향)
    private static void dfs(int x, int y, int depth, int sum) {
        if(depth == 4){ // 탈출 조건
            answer = Math.max(answer, sum);
            return;
        } 

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if( nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] ) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth+1, sum + square[nx][ny]);
                visited[nx][ny] = false; // 백트랙킹
            }

            
        }
    } 
    

    // ㅜ (방향)
    private static void tShapeSearch(int x , int y){
        for(int[][] shape : Tshape) {
            sum = 0;
            boolean valid = true;
            for(int[] d : shape) {
                int nx = x + d[0];
                int ny = y + d[1]; 
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    valid = false;
                    break;
                }

                sum += square[nx][ny];
            } 

            if(valid) answer = Math.max(answer, sum);
        }
    }

}