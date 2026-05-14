import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            
            bfs(computers, visited, i);
            answer++;
        }
        
        return answer;
    }
    
    static void bfs(int[][] computers, boolean[] visited, int start) {
        int n = computers.length;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < n; i++) {
                if (visited[i]) continue;
                if(computers[cur][i] != 1) continue;
                
                visited[i] = true;
                q.offer(i);
                
            }     
            
            
            
        }
    }
    
    
}