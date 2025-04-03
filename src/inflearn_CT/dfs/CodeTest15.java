package inflearn_CT.dfs;

public class CodeTest15 {

    public void DFS(int value){
        if(value == 0) return;
        else {
            DFS(value-1);
            System.out.print(value+" ");
        }

    }

    public static void main(String[] args) {
        CodeTest15 cd = new CodeTest15();
        cd.DFS(3);
    }
}
