import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(char c : number.toCharArray()) {
            
            int num = c - '0';
            
            if(stack.isEmpty()){
                stack.push(num);
                continue;
            }
            
            while( k > 0 && !stack.isEmpty() && stack.peek() < num ) {
                k--;
                stack.pop();
            }
            
            
            stack.push(num);            
        }              
        
        while (k > 0 && !stack.isEmpty()) {
            stack.pop(); 
            k--;
        }           
            
        StringBuilder sb = new StringBuilder();  
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        answer = sb.reverse().toString();
        
        return answer;
    }
}