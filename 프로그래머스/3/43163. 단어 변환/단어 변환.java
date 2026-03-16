import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean found = false;
        
        visited = new boolean[words.length];
        
        for(int i = 0; i < words.length; i++){
            if(target.equals(words[i])){
                found = true;
                break;
            }
            
            
        }
        if(!found) return 0;
        
        
        answer = bfs(begin, target, words, visited);
        
                
        
        
        return answer;
    }
    
    private static int bfs(String begin, String target, String[] words, boolean[] visited ){
        Queue<String[]> q = new LinkedList<>();
        q.offer(new String[]{begin, "0"});
        while(!q.isEmpty()){
            String[] cur = q.poll();
            String word = cur[0];
            int count = Integer.parseInt(cur[1]);
            int idx = 0;
            for(String w : words){
                int diff = 0;
                
                
                for(int i = 0; i< word.length(); i++){
                    if(word.charAt(i) != w.charAt(i)) diff++;
                  
                }
                if(diff == 1 && !visited[idx]){
                    if(target.equals(w)){
                        return count + 1;
                    }
                    visited[idx] = true;
                    q.offer(new String[]{w, (count+1)+""});
                }
                idx++;
            }
            
        }
        
        return 0;
    }
}