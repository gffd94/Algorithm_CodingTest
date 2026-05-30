import java.util.*;

class Solution {
    
    static int count;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 자료형정리 인접리스트
        List<Integer>[] tree = new ArrayList[n+1];
        
        for(int i=1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < n-1; i++) {
            int idx = wires[i][0];
            int value = wires[i][1];
            
            tree[idx].add(value);
            tree[value].add(idx);
            
        }
    
        for(int i = 1; i < n; i++) {
            count = 0;
            visited = new boolean[n+1];
            
            dfs(wires[i-1][0],wires[i-1][1],tree);
            answer = Math.min(answer, Math.abs(count - (n-count)));
        }
        
        
        return answer;
    }
    
    // 1,3/ 2,3/ 3,4/ ....
    static void dfs(int x, int y, List<Integer>[] tree) {
        count++;
        visited[x] = true;
        
        for(int next : tree[x]) {
            if(next == y) continue;
            if(visited[next]) continue;            
            
            dfs(next, y,tree);
            
        }
        
        return;
    }

}