package baekjoon_CT.stack_queue;

import java.util.*;
import java.io.*;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusPQ = new PriorityQueue<>();
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            // minusPQ에 담기
            if(num < 0){
                minusPQ.offer(num);
            } else if(num > 0){ // plusPQ 담기
                plusPQ.offer(num);
            } else { // 출력
                if(plusPQ.isEmpty() && minusPQ.isEmpty()){
                    sb.append(0).append("\n");
                } else if(plusPQ.isEmpty()) {
                    sb.append(minusPQ.poll()).append("\n");
                } else if (minusPQ.isEmpty()) {
                    sb.append(plusPQ.poll()).append("\n");
                } else {
                    // 둘다 값이 있다면 peek()로 비교
                    long plusMin = plusPQ.peek();
                    long minusMin = Math.abs(minusPQ.peek());

                    // 절대값이 같거나 음수 쪽의 절대값이 더 작으면 음수 출력
                    if(minusMin <= plusMin){
                        sb.append(minusPQ.poll()).append("\n");
                    } else {
                        sb.append(plusPQ.poll()).append("\n");
                    }
                }
            }

        }

        System.out.println(sb.toString());

    }
}
