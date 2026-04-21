import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색
        int left = 1;
        int right = N;
        int answer = 0;

        while(left <= right) {
            int mid = (left + right)/2;

            if(check(mid, cards, M)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }

    // 슬라이딩 윈도우 + 중복 탐색
    private static boolean check(int k, int[] cards, int M) {
        boolean[] visited = new boolean[5000001];

        // 카드팩 만족하는 수
        int count = 0;
        int lt = 0;

        for(int rt = 0; rt < cards.length; rt++) {
            // 중복 체크
            if(visited[cards[rt]]) {
                while(visited[cards[rt]]){
                    visited[cards[lt]] = false;
                    // 왼쪽 증가
                    lt++;
                }
            }
            visited[cards[rt]] = true;

            // 윈도우 크기가 k면
            if(rt - lt + 1 == k) {
                count++;
                for(int i = lt; i <= rt; i++){
                    visited[cards[i]] = false;
                }
                lt = rt + 1;
            }
        }

        return count >= M;
    }

}