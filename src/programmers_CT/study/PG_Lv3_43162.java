package programmers_CT.study;
import java.util.*;

public class PG_Lv3_43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(i, n, computers, visited);
                dfs(i, computers, visited);
                answer++;
            }

        }



        return answer;
    }
    // bfs 풀이
    private void bfs(int start, int n, int[][] computers, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0; i < computers[cur].length; i++){
                if(computers[cur][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
    //dfs 풀이
    private void dfs(int start, int[][] computers, boolean[] visited){
        visited[start] = true;
        for(int i = 0; i < computers[start].length; i++){
            if(!visited[i] && computers[start][i] == 1){
                dfs(i, computers, visited);
            }
        }
    }
}
