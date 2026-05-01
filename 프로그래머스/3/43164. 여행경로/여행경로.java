import java.util.*;
class Solution {
    String[] answer;
    boolean[] visited;
    int target;
    boolean found = false;
    
    public String[] solution(String[][] tickets) {
        target = tickets.length;
        visited = new boolean[target];
        
        // 도착지 알파벳 순 정렬
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", path, tickets, 0);
        
        return answer;
    }
    
    void dfs(String current, List<String> path, String[][] tickets, int count) {
        if(found) return;
        
        if(count == target) {
            answer = path.toArray(new String[0]);
            found = true;
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], path, tickets, count + 1);
                if(found) return;
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}