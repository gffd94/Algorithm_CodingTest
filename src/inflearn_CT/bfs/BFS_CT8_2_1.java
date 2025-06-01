package inflearn_CT.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_CT8_2_1 {

    public int BFS(int s, int[] arr){

        int[] check = new int[s+1];
        Queue<Integer> Q = new LinkedList<Integer>();

        check[s] = 1;
        Q.offer(1);
        int L = 0;
        while(!Q.isEmpty()){

            int size = Q.size();
            for(int i = 0; i < size; i++){
                int cur = Q.poll();
                int len = arr[cur];
                for(int j = 1; j <= len; j++){
                    int nCur = cur + j;
                    if(nCur == s) return L+1;
                    if(nCur >= 1 && nCur <= s && check[nCur] == 0){
                        Q.offer(nCur);
                        check[nCur] = 1;
                    }
                }
            }

            L++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BFS_CT8_2_1 T = new BFS_CT8_2_1();
        int s = sc.nextInt();
        int[] arr = new int[s+1];
        for (int i = 1; i <= s; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.BFS(s, arr));
    }

}
