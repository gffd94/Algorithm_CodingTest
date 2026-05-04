import java.util.*;

class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
   
    public int solution(int[][] maps){

        // N,M maps 행과 열
        int N = maps.length;
        int M = maps[0].length;
        
        // 방문처리 visited
        boolean[][] visited = new boolean[N][M];
        
        // queue 선언
        Queue<int[]> queue = new ArrayDeque<>();
            
        // 시작점 , 1 
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
        int[] current = queue.poll();
        int cx = current[0];
        int cy = current[1];
        int dist = current[2];
        
        // 도착지면 즉시 종료
        if(cx == N-1 && cy == M-1) {
            return dist;
        }
            
        // 4방향 탐색
        for(int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            
            // 조건 여과
            if( nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || maps[nx][ny] != 1) {
                continue;
            }
            
            visited[nx][ny] = true;
            queue.offer(new int[]{nx, ny, dist+1});
        }    
        
        
        
        }    
            
        // queue 비었는데 도착 못하면 -1
        return -1;

    }
}