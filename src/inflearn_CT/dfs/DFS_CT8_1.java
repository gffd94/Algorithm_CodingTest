package inflearn_CT.dfs;

public class DFS_CT8_1 {

    public void DFS(int value){
        if(value == 0) return;
        else {
            DFS(value-1);
            System.out.print(value+" ");
        }

    }

    public static void main(String[] args) {
        DFS_CT8_1 cd = new DFS_CT8_1();
        cd.DFS(3);
    }
}
