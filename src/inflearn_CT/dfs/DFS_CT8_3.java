package inflearn_CT.dfs;

public class DFS_CT8_3 {

    public int DFS(int n) {
        if( n == 1 ) {
            return 1;
        }else {
            return n*DFS(n-1);
        }

    }

    public static void main(String[] args) {
        DFS_CT8_3 cd17 = new DFS_CT8_3();
        System.out.println(cd17.DFS(5));
    }
}
