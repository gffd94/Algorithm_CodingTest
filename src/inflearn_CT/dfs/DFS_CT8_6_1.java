package inflearn_CT.dfs;

import java.util.Scanner;

public class DFS_CT8_6_1 {


    static int target = 3;
    static int[] arr = {1,2,3};
    static int n = arr.length;
    static int[] ch;

    public void DFS(int L, int sum) {

        if(L == n){
            if(target == sum){
                StringBuilder tmp = new StringBuilder();
                for(int i = 0 ; i < n ; i++){
                    if(ch[i] == 1){
                        tmp.append(arr[i]).append(" ");
                    }
                }
                if (!tmp.isEmpty()) {
                    System.out.println(tmp);
                }
            }
        }else {

            ch[L] = 1;
            DFS(L+1, sum+ arr[L]);

            ch[L] = 0;
            DFS(L+1, sum);
        }
    }

    public static void main(String[] args) {
        DFS_CT8_6_1 tree = new DFS_CT8_6_1();
        ch = new int[n];
        tree.DFS(0, 0);
    }

}
