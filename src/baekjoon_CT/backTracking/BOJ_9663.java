package baekjoon_CT.backTracking;

import java.io.*;
import java.io.*;

public class BOJ_9663 {
    static int N;
    static boolean[][] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N]; // N X N 체스판

        nQueen(0);

        System.out.println(count);
    }

    private static void nQueen(int row) {
        // BaseCase를 모두 놓았으면 성공
        if(row == N){
            count++;
            return;
        }

        for(int col = 0; col < N; col++){
            // (row,col)에 놓을 수 있는지 검사.
            if(isValid(row,col)){
                visited[row][col] = true; // 퀸 놓기 (방문 처리)
                nQueen(row+1); // 다음 행으로 이동
                visited[row][col] = false; // 백트랙킹 (퀸 회수)
            }
        }
    }

    private static boolean isValid(int row, int col) {
        // 1. 위쪽 방향(같은 열) 체크
        for (int i = 0; i < row; i++) {
            if (visited[i][col]) return false;
        }
        // 2. 왼쪽 대각선 위 체크
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (visited[i][j]) return false;
        }
        // 3. 오른쪽 대각선 위 체크
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (visited[i][j]) return false;
        }
        // 3가지 다 통과하면 true;
        return true;
    }
}
