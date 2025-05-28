package inflearn_CT.dfs;

public class DFS_CT8_4_2 {
    /*
    * 기존 피보나치 수열로 문제를 풀어보니 속도가 굉장히 느리다는 걸 알수있다.
    * 또한 피보나치의 특징은 같은 n값을 몇번이고 반복해서 호출한다는 점이다
    * 이를 개선하고자 fibo라는 배열을 생성해서 값을 저장해보기로 했다
    * */
    // 값을 저장할 배열
    static int[] fibo;
    
    static public int DFS(int n){
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
          int n = 7;
          // 1번부터 확인
          fibo = new int[n+1];
          DFS(n);
          for (int i = 1; i <= n; i++) {
              System.out.print(DFS(i)+" ");
            }
    }
}
