import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        // 한쪽 씩 두 큐 길이만큼 원소가 찰 때가 최대.
        int limit = 2 * (queue1.length + queue2.length)  + 1;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        long q1Sum = 0;
        long q2Sum = 0;
        int count = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            
            q1Sum += queue1[i];
            q2Sum += queue2[i];
        }
        
        if((q1Sum+q2Sum) % 2 != 0) return -1;
        
        // limit까지 계속 반복하면서 서로 같게 되는 최소 횟수 탐색
        while(count < limit) {
            // 종료조건
            if(q1Sum == q2Sum) return count;
            
            if(q1Sum > q2Sum) {
               int value = q1.poll();
                q2.offer(value);
                q1Sum -= value;
                q2Sum += value;
            } else {
                int value = q2.poll();
                q1.offer(value);
                q2Sum -= value;
                q1Sum += value;
            }
            
            
            count++;
        }
        
        if(q1Sum == q2Sum) return count;
        
        
        return -1;
    }
}