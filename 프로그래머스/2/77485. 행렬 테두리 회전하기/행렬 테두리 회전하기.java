import java.util.*;

class Solution {
    
    static int[][] matrix;
    static List<int[]> board;
    static List<Integer> values;
    static List<Integer> answer;
    
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        answer = new ArrayList<>();
        int idx = 1;
        
        // 판 채우기
        matrix = new int[rows+1][columns+1];
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                matrix[i][j] = idx++;
            }
        }
        
        for(int[] xy : queries) {
            // board에 좌표값 집어넣기 (y좌표, x좌표);
            board = new ArrayList<>();
            int[] start = new int[]{xy[0],xy[1]};
            int[] end = new int[]{xy[2],xy[3]};
            values = new ArrayList<>();
            
            // board 좌표, values 해당 값 세팅
            setting(board, start, end, values);
        
            // 시계방향대로 전환
            timeCircle(values);
            
            // 최솟값 찾기
            minSearch(values);
            
            // 다시 matirx에 반영
            reSetting(values, matrix, board);
        }
        
        return answer;
    }
    
    // 시계방향 (위-> 우-> 아래-> 좌) - 중복 값은 다음으로 넘김.
    static void setting(List<int[]> board, int[] start, int[] end, List<Integer> values) {
        for(int i = 0; i < end[1] - start[1]; i++) {
            int[] pos = new int[]{start[0],start[1]+i};
            board.add(pos);
            values.add(matrix[pos[0]][pos[1]]);
        }
        for(int i = 0; i < end[0] - start[0]; i++) {
            int[] pos = new int[]{start[0] + i, end[1]};
            board.add(pos);
            values.add(matrix[pos[0]][pos[1]]);
        }
        for(int i = 0; i < end[1] - start[1]; i++) {
            int[] pos = new int[]{end[0],end[1]-i};
            board.add(pos);
            values.add(matrix[pos[0]][pos[1]]);
        }
        for(int i = 0; i < end[0] - start[0]; i++) {
            int[] pos = new int[]{end[0]-i, start[1]};
            board.add(pos);
            values.add(matrix[pos[0]][pos[1]]);
        }
    }
    
    // 시계방향으로 회전
    static void timeCircle(List<Integer> values) {        
        int last = values.remove(values.size() - 1);
        values.add(0, last);
    }
    
    // 최솟값 찾기
    static void minSearch(List<Integer> values) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < values.size(); i++) {
            int num = values.get(i);
            min = Math.min(min, num);
        }
        
        answer.add(min);
        
    }
    
    // 방향전환한 값 matrix에 저장
    static void reSetting(List<Integer> values, int[][] matrix, List<int[]> board) {
        int n = values.size();
        for(int i = 0; i < n; i++) {
            int[] pos = board.get(i);
            // int prev = (i - 1 + n) % n;
            matrix[pos[0]][pos[1]] = values.get(i);
        }
    }
}