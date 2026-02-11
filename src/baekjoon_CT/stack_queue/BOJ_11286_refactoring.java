package baekjoon_CT.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11286_refactoring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
            long absA = Math.abs((long) a);
            long absB = Math.abs((long) b);

            if(absA == absB){
                return Long.compare(a,b);
            }

            return Long.compare(absA,absB);
        });

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(num);
            }
        }

        System.out.println(sb.toString());

    }
}
