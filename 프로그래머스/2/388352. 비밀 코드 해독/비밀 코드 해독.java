import java.util.*;

class Solution {
    int answer = 0;
    int n1;
    int[][] q1;
    int[] ans1;
    
    public int solution(int n, int[][] q, int[] ans) {
        n1 = n;
        q1 = q;
        ans1 = ans;
        int[] current = new int[5];
        
        combination(1, current, 0);
        
        return answer;
    }
    
    public void combination(int start, int[] current, int depth) {
        if(depth == 5) {        
            boolean valid = true;
            
            for(int i = 0; i<q1.length; i++){
                int cnt = 0;
                for(int j = 0; j < 5; j++){
                    for(int k = 0; k < 5; k++) {
                        if(q1[i][j] == current[k]) cnt++;
                    }
                }
                
                if(cnt != ans1[i]) valid = false;
                
            }
            
            if(valid) answer++;
            return;
        }
        
        for(int i = start; i <= n1; i++) {
            current[depth] = i;
            combination(i+1, current, depth+1);
        }
    }
    
}