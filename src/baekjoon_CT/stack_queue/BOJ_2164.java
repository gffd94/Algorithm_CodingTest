package baekjoon_CT.stack_queue;

import java.util.*;

public class BOJ_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            // 1. 첫번째 수행 : 맨 위 카드 제거.
            queue.poll();
            // 2. 두번째 수행 : 맨 위 카드 맨 아래로 옮김.
            queue.offer(queue.poll());
        }

        answer = queue.poll();
        System.out.println(answer);
    }
}
