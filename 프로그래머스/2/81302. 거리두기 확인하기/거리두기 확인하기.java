import java.util.*;

class Solution {
    
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            answer[i] = checkOne(places[i]);            
        }
        
        
        
        return answer;
    }
    
    static int checkOne(String[] grid) {
        char[][] maps = new char[5][5];
        Queue<int[]> ps = new ArrayDeque<>();
        
        // 대기실 생성
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                maps[i][j] = grid[i].charAt(j);
                // p 위치 찾기        
                if(maps[i][j] == 'P') ps.offer(new int[] {i,j});
            }    
        }
        
        // 모든 p 순환
        while(!ps.isEmpty()) {
            int[] curP = ps.poll();
            int x = curP[0];
            int y = curP[1];
            
            // 위반이면 false, 위반아니면 true
            if(!bfs(x,y,maps)) {
                return 0;
            }
            
        }
            return 1;
        
        
    }
    
    static boolean bfs(int x, int y, char[][] maps) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y,0});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];
            
            for(int i = 0; i< 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // 기본 조건 
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny]) continue;
                // 맨해튼 거리 3이상 일 때 판단 x
                if(dist + 1 > 2) continue;
                
                // P를 만났을 때
                if(maps[nx][ny] == 'P') return false;
                // X를 만났을 때
                if(maps[nx][ny] == 'X') continue;
                // O를 만났을 때
                if(maps[nx][ny] == 'O') {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,dist+1});
                }
                
            }            
        }
        
        return true;
        
    }
    
    
}