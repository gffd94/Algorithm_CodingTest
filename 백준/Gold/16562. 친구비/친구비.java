import java.util.*;
import java.io.*;

public class Main {

    static int[] cost;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        cost = new int[N+1];
        for(int i = 1; i <= N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            union(A,B);
        }

        int total = 0;
        for(int i = 1; i <= N; i++){
            if(find(i) == i){
                total += cost[i];
            }
        }

        if(total<=K){
            System.out.println(total);
        }else{
            System.out.println("Oh no");
        }

    }

    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union (int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return;
        if(cost[a]<cost[b]){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
}