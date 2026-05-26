import java.util.*;

class Solution {   
    
    static Set<Integer> numbering;
    static int len;
    
    public int solution(String numbers) {
        int answer = 0;           
        len = numbers.length();
        
        numbering = new HashSet<>();
        boolean[] visited = new boolean[len*len];
        String current = "";
        
        dfs(numbers, visited, current);
        
       for(int sosu : numbering) {

           if(isPrime(sosu)) answer++;
       }
        
        return answer;
    }      
    
    
    static void dfs(String numbers, boolean[] visited , String current) {
        // current 값이 있으면 set
        if(!current.isEmpty()) {
            numbering.add(Integer.parseInt(current));
        }
        
        for(int i = 0; i < len; i++) {
         
            if(visited[i]) continue;
            
            visited[i] = true;
            dfs(numbers, visited, current + numbers.charAt(i));
            visited[i] = false;
            
        }
        
    }
    
    static boolean isPrime (int sosu) {
        
        if(sosu <= 1) return false;
        
        for(int i = 2; i * i <= sosu; i++) {
            if(sosu % i == 0) return false;
        }
        
        return true;
    }
    
}