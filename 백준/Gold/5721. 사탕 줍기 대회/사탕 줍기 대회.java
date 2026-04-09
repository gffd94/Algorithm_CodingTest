import java.util.*;
import java.io.*;

public class Main {

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if(M == 0 && N == 0) break;

            int[][] boxs = new int[M][N];

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    boxs[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] dpRow = new int[M];
            int[] dpCol = new int[M];
            int[] check;

            // 각 행에 대하여 열을 기준으로 인접하지 않는 수를 고를 때 최대 값
            for(int i = 0; i < M; i++) {
                if(N == 1) {
                    dpCol[i] = boxs[i][0];
                }else {
                    check = new int[N];
                    check[0] = boxs[i][0];
                    check[1] = Math.max(check[0], boxs[i][1]);
                    for(int j = 2; j < N; j++) {
                        check[j] = Math.max(check[j-1], check[j-2]+boxs[i][j]);
                    }

                    dpCol[i] = check[N-1];
                }
                
            }

            if(M == 1) {
                System.out.println(dpCol[0]);
                continue;
            }

            dpRow[0] = dpCol[0];
            dpRow[1] = Math.max(dpRow[0], dpCol[1]);

            for(int i = 2; i < M; i++) {
                dpRow[i] = Math.max(dpRow[i-1], dpRow[i-2] + dpCol[i]);
            }

            int answer = dpRow[M-1];
            
            System.out.println(answer);
        }
    }

}
