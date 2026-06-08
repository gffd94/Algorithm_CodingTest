import java.util.*;

class Solution {
    static int[] parents;
    
    static int find(int x) {
        if(parents[x] == x) return x;
        return find(parents[x]);
    }
    
    static void unionFind(int a, int b) {
        parents[find(a)]  = find(b);
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        // 비용에 따른 오름차순 정렬
        Arrays.sort(costs, (p1, p2) -> {
            return p1[2] - p2[2];
        });
            
        for(int i = 0; i < costs.length; i++) {
            int parentA = costs[i][0];
            int parentB = costs[i][1];
          
            
            if(find(parentA) == find(parentB)) {
                 continue;
            } else {
                answer += costs[i][2];
                unionFind(parentA, parentB);
            }
        }    
        
        return answer;
    }
}