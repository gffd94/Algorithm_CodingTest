import java.util.*;

class Solution {
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, 0, visited, dungeons);
        
        return answer;
    }
    
    public void dfs (int k, int cnt, boolean[] visited, int[][] dungeons) {
        answer = Math.max(answer, cnt);
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                cnt++;
                k -= dungeons[i][1];
                dfs(k, cnt, visited, dungeons);
                visited[i] = false;
                cnt--;
                k += dungeons[i][1];
                
            }
        }
    }
    
}