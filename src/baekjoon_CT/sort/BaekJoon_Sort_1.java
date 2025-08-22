package baekjoon_CT.sort;

import java.io.*;
import java.util.PriorityQueue;

public class BaekJoon_Sort_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(br.readLine().trim());
            pq.offer(x);
        }

        if (pq.size() <= 1) {
            System.out.println(0);
            return;
        }

        long sum = 0L;
        while (pq.size() > 1) {
            long x = pq.poll();
            long y = pq.poll();
            long z = x + y;
            sum += z;
            pq.offer(z);
        }

        System.out.println(sum);

    }
}
