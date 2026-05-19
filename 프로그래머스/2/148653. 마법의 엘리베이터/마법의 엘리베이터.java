import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            // 1의자리 
            int d = storey%10;  
            if(d > 5) {
                answer += 10 - d;
                storey = (storey/10)+1;
            } else if(d < 5) {
                answer += d;
                storey = (storey/10);
            }else {
                answer += 5;
                storey = (storey/10);
                if (storey % 10 >= 5) storey += 1;
            }
        }
        
        return answer;
    }
}