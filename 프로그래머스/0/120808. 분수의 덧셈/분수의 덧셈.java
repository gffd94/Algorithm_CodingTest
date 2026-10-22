import java.util.*;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int lcm = (denom1 * denom2) / god(denom1, denom2);
        int num = (numer1 * (lcm/denom1)) + (numer2 * (lcm/denom2));
        
        int g = god(lcm,num); // 기약분수 처리
        
        return new int[]{num/g, lcm/g};
    }
    
    private int god(int a, int b) {
        if(b==0){
            return a;   
        }
        
        return god(b, a%b);
    }
    
}