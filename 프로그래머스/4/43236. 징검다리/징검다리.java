import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        int[] rocksloot = new int[rocks.length+1];
        for(int i = 0; i < rocksloot.length; i++) {
            if( i == rocksloot.length-1) {
                rocksloot[i] = distance;
            } else {
                rocksloot[i] = rocks[i];
            }
        }
        
        int lt = 1;
        int rt = distance;
        
        while(lt<=rt) {
            int mid = (lt+rt)/2;
            int count = rockCounting(rocksloot, mid);
            if(count <= n) {
                answer = mid;
                lt = mid+1;
            } else {
                rt = mid - 1;
            }
        }
        
        return answer;
    }
    
    public static int rockCounting(int[] rocksloot, int mid) {
        int last = 0;
        int cnt = 0;
        for(int i = 0; i < rocksloot.length; i++) {
            int num = rocksloot[i] - last;
            if(num < mid) { // 제거
                cnt++;
            }else {
                last = rocksloot[i];
            }
        }
        
        return cnt;
    }
}