
package inflearn_CT.dfs;

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        this.data = val;
        lt = rt = null;
    }
}

// 이진트리순회
public class DFS_CT8_5 {

    Node root;
    public void DFS(Node root){
        if(root == null) return;
        else {
            // 전위 순회
//            System.out.println(root.data+ " ");
            DFS(root.lt);
            // 중위 순회
//            System.out.println();
            DFS(root.rt);
            // 후위순회
//            System.out.println();
        }
    }

    public static void main(String[] args) {
        DFS_CT8_5 tree = new DFS_CT8_5();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
    }

}
