import java.util.*;

class Solution {
    
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] start;
    static int[] end;
    static int rows, cols;
    
    public int solution(String[] board) {
        
        rows = board.length;
        cols = board[0].length();
        char[][] games = new char[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        
        // 시작점과 도착지점 찾기
        for(int i = 0; i < rows; i++) {
            String str = board[i];
            for(int j = 0; j < cols; j++) {
                char c = str.charAt(j);
                games[i][j] = c;
                
                if(c == 'R') {
                    start = new int[]{i,j};
                    visited[i][j] = true;
                }
                
                if(c == 'G') {
                    end = new int[]{i,j};
                }
            }
        }
        
        // bfs 탐색 (시작 위치, 도착 지점, games, 방문처리)
        int answer = bfs(start, end, games, visited);
        
        return answer;
    }
    
    static int bfs(int[] start, int[] end, char[][] games, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        int dist = 0;
        q.offer(new int[]{start[0],start[1],dist});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            dist = cur[2];
            
            // 목적지 도착시 종료
            if(cx == end[0] && cy == end[1]) return dist;
            
            for(int i = 0; i < 4; i++) {
                
                int nx = cx;
                int ny = cy;
                
                // 슬라이드 : 다음 칸이 이동가능한지 반펼
                while(true){
                    int snx = nx + dx[i];
                    int sny = ny + dy[i];
                    
                    if(snx < 0 || snx >= rows || sny < 0 
                                    || sny >= cols || games[snx][sny] == 'D') break;
                    
                    nx = snx;
                    ny = sny;
                }
                
                if(visited[nx][ny]) continue;
                
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,dist+1});
                
            }
        }
        
        return -1;
        
    }
    
    
}