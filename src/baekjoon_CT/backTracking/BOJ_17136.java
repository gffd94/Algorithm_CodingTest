package baekjoon_CT.backTracking;

import java.io.*;
import java.util.*;

public class BOJ_17136 {
    static int[][] map = new int[10][10];
    static int[] M = {0, 5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE; // 최소 사용 갯수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0,0); // 좌표 , 사용한 색종이 수
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }

    private static void backtracking(int xy, int useCnt) {
        // 정답처리 (99까지 다 확인하고 났을 때 최소 결과 출력)
        if(xy == 100){
            result = Math.min(result, useCnt);
            return;
        }
        int row = xy / 10;
        int col = xy % 10;
        // 가지치기
        if(result <= useCnt) return;
        if(map[row][col] == 1) {
            // 색종이 넓이가 큰 것부터 확인.
            for (int i = 5; i > 0; i--) {
                // 색종이 수가 0보다 크고 1인 곳 확인
                if(M[i] > 0 && check(row, col, i)){
                    // 백트랙킹
                    M[i]--; // 색종이 사용
                    fill(row, col, i, 0); // 채우는 함수
                    backtracking(xy+1, useCnt+1); // 위치와 사용 수 증가.
                    fill(row, col, i, 1); // 다시 색종이 떼기
                    M[i]++; // 색종이 반납
                }
            }
        }else {
            // 0 이라면 위치만 이동.
            backtracking(xy+1, useCnt);
        }



    }

    private static void fill(int row, int col, int size, int num) {
        // 0을 넣는 이유 : 그만큼 사용했다는 의미.
        for (int r = row; r < size+row; r++) {
            for (int c = col; c < size+col; c++) {
                map[r][c] = num;
            }
        }
    }

    private static boolean check(int row, int col, int size) {
        // 위치 + 종이 크기가 전체 범위인지 확인
        if(row+size > 10 || col+size > 10) return false;
        // 그 안에 1로만 되어 있는 가
        for (int r = row; r < size+row; r++) {
            for (int c = col; c < size+col; c++) {
                if(map[r][c] != 1) return false;
            }
        }
        return true;
    }
}
