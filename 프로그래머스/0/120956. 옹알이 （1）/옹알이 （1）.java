import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] sounds = {"aya", "ye", "woo", "ma"};
        
        for(String b : babbling) {
            // sounds 체크
            boolean[] check = new boolean[4];
            int strLen = 0; // 옹알이 누적 길이
            boolean ok = true;
            
            while(strLen < b.length()) {
                // 문자와 매칭이 있는지 없는지
                boolean flag = false;
                // sounds 순회
                for(int i = 0; i < 4; i++) {
                    boolean c1 = b.startsWith(sounds[i],strLen);
                    if(c1 && !check[i]){
                        check[i] = true;
                        // 문자를 지우는 대신 이동
                        strLen += sounds[i].length();
                        flag = true;
                        break;
                    }
                }
                
               if(!flag) {
                    ok = false;
                    break;
                }
            }
            
            
            if(ok){
                answer++;
            }
            
            
        }
        
        
        return answer;
    }
}