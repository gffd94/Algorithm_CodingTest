package baekjoon_CT.bfs_dfs;
import java.util.*;
import java.io.*;

public class BOJ_1722 {
    static int N;
    static long num;
    static long[] parts = new long[21];
    static boolean[] visited = new boolean[21];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parts[0] = 1;
        for(int i = 1; i <= 20; i++){
            parts[i] = parts[i-1] * i;
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        if(M == 1){
            num = Long.parseLong(st.nextToken());
            find(num);
        }else {
           int[] target = new int[N+1];
           for(int i = 1; i <= N; i++){
               target[i] = Integer.parseInt(st.nextToken());
           }
            findNum(target);
        }


    }

    static void find(long num) {
        int[] answer = new int[N+1];

        // 1번째 자리부터 N번째 자리까지 채움
        for( int i = 1; i <= N; i++){
            long chunk = parts[N-i]; // 뭉탱이 단위

            // 1 부터 N까지 숫자 중 들어갈 수를 찾음
            for(int j = 1; j <= N; j++){
                if(visited[j]) continue; // 이미 사용한 수 패스

                // num이 뭉텅이보다 그면 건너 뜀
                if(num > chunk){
                    num -= chunk;
                } else { // 여기가 들어갈 자리
                    answer[i] = j;
                    visited[j] = true;
                    break;
                }
            }
        }

        for(int i = 1; i <= N; i++){
            System.out.print(answer[i] + " ");
        }
    }

    static void findNum (int[] target) {
        long answer = 1;

        // 1 부터 N까지 자리 확인
        for(int i = 1; i <= N; i++){
            long chunk = parts[N-i];

            // target보다 작은 숫자 까지만 확인
            for(int j = 1; j < target[i]; j++){
                if(!visited[j]){
                    answer += chunk;
                }
            }

            visited[target[i]] = true;
        }

        System.out.println(answer);
    }

}
