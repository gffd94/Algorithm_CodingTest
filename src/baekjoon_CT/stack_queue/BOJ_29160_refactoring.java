package baekjoon_CT.stack_queue;

import java.io.*;
import java.util.*;

public class BOJ_29160_refactoring {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Map 보다 배열이 더 시간초과의 위험성이 적어서 배열로 접근해서 다시 풀이
        PriorityQueue<Integer>[] teampq = new PriorityQueue[12];
        // 포지션 별 PQ 초기화
        for(int i = 1; i <= 11; i++){
            teampq[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        // 선수 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            teampq[pos].offer(value); // 포지션에 맞는 선수 추가
        }
        // K년 까지 선발선수 작업
        for(int i = 0; i < K; i++){
            // (1번부터 11번까지)
            for(int pos = 1; pos <= 11; pos++){
                if(teampq[pos].isEmpty()) continue;

                int topPlayer = teampq[pos].poll();
                if(topPlayer > 0) {
                    topPlayer--;
                }

                teampq[pos].offer(topPlayer);
            }
        }

        long total = 0;
        for(int pos = 1; pos <= 11; pos++){
            if(!teampq[pos].isEmpty()){
                total += teampq[pos].peek();
            }
        }

        System.out.println(total);
    }

}
