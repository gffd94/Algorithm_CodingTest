import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int[][] pairs = {{0,1,2,3}, {0,2,1,3}, {0,3,1,2}};
        int answer = 0;
        
        for(int[] pair : pairs) {
            int[] a = dots[pair[0]];
            int[] b = dots[pair[1]];
            int[] c = dots[pair[2]];
            int[] d = dots[pair[3]];
            
            int dx1 = a[0] - b[0];
            int dy1 = a[1] - b[1];
            int dx2 = c[0] - d[0];
            int dy2 = c[1] - d[1];
            
            if(dx1 * dy2 == dy1 * dx2) answer = 1;
         }
        
        return answer;
    }
}