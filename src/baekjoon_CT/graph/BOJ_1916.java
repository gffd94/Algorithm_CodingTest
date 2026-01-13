package baekjoon_CT.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {

    static ArrayList<Edge>[] arr;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new ArrayList[N+1];
        distance = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[from].add(new Edge(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(distance[end]);

    }

    static void dijkstra(int start){

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){
            Node current = pq.poll();
            int curNode = current.to;
            int curDist = current.cost;

            if(curDist > distance[curNode]) continue;

            for (Edge next : arr[curNode]) {
                int nextNode = next.to;
                int nextDist = curDist + next.cost;

                if(nextDist < distance[nextNode]){
                    distance[nextNode] = nextDist;
                    pq.add(new Node(nextNode, nextDist));
                }
            }
        }

    }

    static class Node{
        int to;
        int cost;

        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    static class Edge{
        int to;
        int cost;

        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
}
