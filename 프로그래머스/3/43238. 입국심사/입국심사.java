import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < times.length; i++) {
            min = Math.min(min , times[i]);
        }
        long lt = 1;
        long rt = (long) n * min;
        while( lt <= rt) {
            long mid = (lt+rt)/2;
            long value = 0;
            for(int i = 0; i < times.length; i++) {
                value += mid/times[i];
            }
            if(value < n) {
                lt = mid+1;
            } else {
                answer = mid;
                rt = mid -1;
            }
        }
        
        return answer;
    }
}