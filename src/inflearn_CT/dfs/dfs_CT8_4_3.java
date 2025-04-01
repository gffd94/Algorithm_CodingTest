package inflearn_CT.dfs;

public class dfs_CT8_4_3 {
    /*
    * fibo라는 배열로 기존 값을 저장해놓고 사용하는 방법을 고안했다
    * 하지만 이 역시도 n의 숫자가 커질수록 속도가 느려진다
    * 그래서 fibo에 기존의 그 값이 있다면 dfs로 탐색하지 말고 바로 값을 가져오는 방법을 생각했다
    * */
    // 값을 저장할 배열
    static int[] fibo;
    
    static public int DFS(int n){
        if(fibo[n] > 0) return fibo[n];

        if(n == 1){
            return fibo[1] = 1;
        }
        else if(n == 2){
            return fibo[2] = 1;
        }else {
            return fibo[n] = DFS(n-2) + DFS(n-1);
        }
    }


    public static void main(String[] args) {
          int n = 45;
          // 1번부터 확인
          fibo = new int[n+1];
          DFS(n);
          for (int i = 1; i <= n; i++) {
              System.out.print(DFS(i)+" ");
            }
    }
}
