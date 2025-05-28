package inflearn_CT.dfs;

public class DFS_CT8_2 {

    static void DFS(int n){
        if(n == 0){
            return;
        }else {
            DFS(n/2);
            System.out.print(n%2+" ");
        }
    }

    public static void main(String[] args) {
        DFS_CT8_2 ct16 = new DFS_CT8_2();
        ct16.DFS(11);
    }


}
