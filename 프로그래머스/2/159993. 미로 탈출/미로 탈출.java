import java.util.*;

class Solution {
    
    static int N, M;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        int sx = 0, sy = 0;
        int lx = 0, ly = 0;
        int ex = 0, ey = 0;
        
        // S,L,E 위치 찾기
        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
                
                if(map[i][j] == 'L') {
                    lx = i;
                    ly = j;
                }
                
                if(map[i][j] == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
        
        // S -> L 까지 bfs
        int a = bfs(sx, sy, lx, ly, map);
        // L -> E 까지 bfs
        int b = bfs(lx, ly, ex, ey, map);
        
        // a || b == -1 이면 탈출 불가
        if(a == -1 || b == -1) return -1;
        
        return a+b;
    }
    
    static int bfs(int stx, int sty, int finx, int finy, char[][] map) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{stx,sty,0});
        visited[stx][sty] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];
            
            for(int i = 0; i< 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || 
                            visited[nx][ny] || map[nx][ny] == 'X') {
                    continue;
                }
                
                // 목표지점에 도달하면 return dist
                if (nx == finx && ny == finy) {
                    return dist + 1;
                }
                
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist+1});
                
            }
        }
        
        // q 탐색을 다했는데 결과가 도달 못했다면 -1
        return -1;
    }
    
}