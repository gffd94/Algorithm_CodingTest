import java.util.*;

class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        // 같으면 등차 다르면 등비
        if((common[1] - common[0]) == (common[2] - common[1])) {
            answer = common[common.length - 1] + (common[1] - common[0]);
        } else {
            int radio = common[1] / common[0];
            answer = common[common.length - 1] * radio;
        }
        
        return answer;
    }
}