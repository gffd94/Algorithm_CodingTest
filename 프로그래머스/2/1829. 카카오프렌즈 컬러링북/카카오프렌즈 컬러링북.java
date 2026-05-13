import java.util.*;

class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0 ,1, 0, -1};
    static int M, N;
    
    public int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        int[] answer = new int[2];
        boolean[][] visited = new boolean[m][n];
        int size = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                if(visited[i][j] || picture[i][j] == 0) continue;
                
                size = bfs(picture, visited, i, j);
                
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
            }
        }
        

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static int bfs(int[][] picture, boolean[][] visited, int sx, int sy) {
        int target = picture[sx][sy];
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            count++;
            
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || nx >= M || ny < 0 || ny >= N ||
                                visited[nx][ny] || picture[nx][ny] != target) continue;
                
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
            
        }
        
        return count;
    }
}