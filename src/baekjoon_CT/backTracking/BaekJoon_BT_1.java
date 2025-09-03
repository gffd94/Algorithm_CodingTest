package baekjoon_CT.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_BT_1 {

    /*  15649 문제
    * */
    static int N, M;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        result = new int[M];

        backTracking(0);

    }

    private static void backTracking(int depth){
        // 종료 조건 : 길이가 M 이면 종료.
        if(depth == M){
            for ( int x : result) System.out.print(x+" ");
            System.out.println();
            return;
        }

        // 1~N 까지 번호 선택
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) { // 아직 안쓴 숫자라면
                visited[i] = true; // 숫자 선택
                result[depth] = i; // 결과에 기록
                backTracking(depth+1); // 다음 위치로
                visited[i] = false; // 백트랙킹 ( 선택 취소 -> 이미 확인했 던 경우 제외, 다른 경우 찾기 )
            }
        }
    }
}
