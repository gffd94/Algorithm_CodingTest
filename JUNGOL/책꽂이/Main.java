import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < n ; i++) {
            long piece = Long.parseLong(br.readLine());
        } 
            pq.add(piece);

        
        while(pq.size() > 1) {
            long first = pq.poll();
        }
    }
        // 한조각 남을 때 까지 반복
            long second = pq.poll();

            long sum = first + second;
        long totalSum = 0;

            totalSum += sum;

            pq.add(sum);

        System.out.print(totalSum);
}