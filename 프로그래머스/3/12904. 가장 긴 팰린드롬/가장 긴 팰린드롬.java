import java.util.*;

class Solution {
    static int answer;
    static String targetS;
    
    public int solution(String s) {
        answer = 0;
        targetS = s;
        
       for(int i = 0; i < s.length(); i++) {
           char word = s.charAt(i);
           int lt = i;
           int rt = i;
           palin(lt, rt);
               
            lt = i;
            rt = i+1;
            palin(lt, rt);
        }
           
        return answer;
        
       }             
    
        static void palin(int lt, int rt) {
               while(lt >= 0 && rt < targetS.length() 
                        && targetS.charAt(lt) == targetS.charAt(rt)) {
               
                   int len = rt - lt +1;
                   answer = Math.max(answer,len);
                   lt--;
                   rt++;
               
                   
               }
        }
        
}
