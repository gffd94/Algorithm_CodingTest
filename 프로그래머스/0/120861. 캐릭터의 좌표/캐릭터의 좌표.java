import java.util.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
                
        // up,down,left,right
        Map<String, int[]> dir = Map.of(
            "up" , new int[] {0, 1},
            "down" , new int[] {0, -1},
            "left" , new int[] {-1, 0},
            "right" , new int[] {1, 0}
        );
        // 가로,세로
        int n = board[0]/2;
        int m = board[1]/2;
        int x = 0, y = 0;
        
        for(String str : keyinput) {
            int[] cur = dir.get(str);
            
            int nx = x + cur[0];
            int ny = y + cur[1];
            
            if(nx < -n || nx > n || ny < -m || ny > m) {
                continue;
            }
            
            x = nx;
            y = ny;
            
        }
        
        
        
        return new int[] {x,y};
    }
}