package baekjoon_CT.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {

    static ArrayList<Node> [] arr;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        arr = new ArrayList[v+1];
        distance = new int[v+1];

        for (int i = 1; i <= v; i++) {
            arr[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        distance[k] = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.add(new Node(k,0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.dest;
            int curDist = current.weight;

            if(curDist > distance[curNode]) continue;

            for (Node next : arr[curNode]) {
                int nextNode = next.dest;
                int nextDist = curDist + next.weight;

                if(nextDist < distance[nextNode]){
                    distance[nextNode] = nextDist;
                    pq.add(new Node(nextNode, nextDist));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if(distance[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else{
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.println(sb);

    }

    static class Node{
        int dest;
        int weight;
        Node(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }

    }
}
