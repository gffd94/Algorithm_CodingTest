package baekjoon_CT.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon_DFS_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> big = new ArrayList<>();
        ArrayList<ArrayList<Integer>> small = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            big.add(new ArrayList<>());
            small.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            big.get(b).add(a); // a가 b보다 크다
            small.get(a).add(b); // b가 a보다 작다
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            boolean[] visit = new boolean[n+1];
            visit[i] = true;
            int heavy = dfs(i, big, visit, 0);
            if(heavy > n/2){
                answer += 1;
                continue;
            }
            int light = dfs(i, small, visit, 0);
            if(light > n/2){
                answer += 1;
                continue;
            }
        }

        System.out.println( answer);
    }

    private static int dfs(int x, ArrayList<ArrayList<Integer>> value,boolean[] visit, int count){
        for (int i = 0; i < value.get(x).size(); i++){
            if(!visit[value.get(x).get(i)]){
                visit[value.get(x).get(i)] = true;
                count += dfs(value.get(x).get(i), value, visit, 1);
            }
        }
        return count;
    }

    // i에 따른 visit 배열 초기화 함수
    private static void init(boolean[] visit){
        for (int i = 0; i < visit.length; i++) {
            visit[i] = false;
        }
    }
}
