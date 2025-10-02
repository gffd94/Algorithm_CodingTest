package baekjoon_CT.backTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon_BT_3 {

    static int[][] arr = new int[9][9];;
    static ArrayList<int[]> zeros= new ArrayList<>();
    static int zeroCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) zeros.add(new int[]{i,j});
            }
        }

        zeroCnt = zeros.size();

        sdoku(0);
    }

    public static boolean sdoku(int k){
        if(zeroCnt == k) {
            result();
            return true;
        }

        int[] spot = zeros.get(k);
        int x = spot[0];
        int y = spot[1];

        for (int i = 1; i <= 9; i++) {
            if(check(x,y,i)){
                arr[x][y] = i;
                if (sdoku(k+1)) return true;
                arr[x][y] = 0;
            }
        }

        return false;
    }

    public static boolean check(int x, int y, int num){
        for (int i = 0; i < 9; i++) {
            if(arr[i][y] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if(arr[x][i] == num) return false;
        }

        for (int i = (x/3)*3; i < (x/3)*3+3; i++) {
            for (int j = (y/3)*3; j < (y/3)*3+3; j++) {
                if(arr[i][j] == num) return false;
            }
        }

        return true;
    }

    public static void result(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]);
                if(j < 8) sb.append(" ");
            }
            if(i < 8) sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
