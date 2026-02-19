package baekjoon_CT.greedy;

import java.util.*;
import java.io.*;

public class BOJ_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++){
            pq.offer(sc.nextInt());
        }
        int num = 0;
        int cnt = 0;
        while(K>0){
            if(!pq.isEmpty()){
                if(pq.peek() > K) {
                    pq.poll();
                } else {
                    num = pq.poll();
                    K -= num;
                    cnt++;
                    pq.offer(num);
                }
            }
        }
        System.out.println(cnt);
    }
}
