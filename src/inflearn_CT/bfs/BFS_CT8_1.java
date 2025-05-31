
package inflearn_CT.bfs;


import java.util.LinkedList;
import java.util.Queue;

class Node {

    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class BFS_CT8_1 {

    Node root;
    public void BFS(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(L+": ");
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                System.out.print(cur.data+" ");
                if(cur.lt != null) q.offer(cur.lt);
                if(cur.rt != null) q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BFS_CT8_1 bfs = new BFS_CT8_1();
        bfs.root = new Node(1);
        bfs.root.lt = new Node(2);
        bfs.root.rt = new Node(3);
        bfs.root.lt.lt = new Node(4);
        bfs.root.lt.rt = new Node(5);
        bfs.root.rt.lt = new Node(6);
        bfs.root.rt.rt = new Node(7);
        bfs.BFS(bfs.root);
    }

}
