import java.util.*;

class Solution {
    public int solution(int[][] board) {
        // 8방향 정의
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        int n = board.length;
        // 위험 지역 체크할 배열
        boolean[][] danger = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1){
                    danger[i][j] = true; // 본인자리도 체크
                    
                    // 8방향으로 위험지역 표시
                    for(int d = 0; d < 8; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        
                        // 보드범위를 벗어나지 않는 경우만
                        if(ni >= 0 && ni < n && nj >= 0 && nj < n) {
                            danger[ni][nj] = true;
                        }
                    }
                }
            }
        }
        
        // 3. 위험지역이 아닌 안전한 칸 개수 카운트
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!danger[i][j]){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}