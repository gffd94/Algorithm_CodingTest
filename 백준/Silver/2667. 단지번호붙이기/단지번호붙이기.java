import java.util.*;
import java.io.*;

public class Main {

    static int[][] maps;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> apart;
    static int aprtSize = 0;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        maps = new int[N][N];
        visited = new boolean[N][N];
        apart = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                maps[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    apart.add(bfs(i, j)); // 넓이 반환
                    aprtSize++;
                }
            }
        }
        
        //출력
        System.out.println(aprtSize);
        Collections.sort(apart);
        if(aprtSize != 0){
            for(int i = 0; i < aprtSize; i++){
                System.out.println(apart.get(i));
            }
        }

    }

    private static int bfs(int curX, int curY){
        Queue<int[]> q = new LinkedList<>(); // dx, dy      
        visited[curX][curY] = true;
        q.offer(new int[]{curX, curY});
        int count = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                    continue;
                }

                if(maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    count++;
                }
            }
        }
            
        return count;

    }

}