public class CodeTest17 {

    public int DFS(int n) {
        if( n == 1 ) {
            return 1;
        }else {
            return n*DFS(n-1);
        }

    }

    public static void main(String[] args) {
        CodeTest17 cd17 = new CodeTest17();
        System.out.println(cd17.DFS(5));
    }
}
