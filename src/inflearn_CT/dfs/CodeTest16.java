package inflearn_CT.dfs;

public class CodeTest16 {

    static void DFS(int n){
        if(n == 0){
            return;
        }else {
            DFS(n/2);
            System.out.print(n%2+" ");
        }
    }

    public static void main(String[] args) {
        CodeTest16 ct16 = new CodeTest16();
        ct16.DFS(11);
    }


}
