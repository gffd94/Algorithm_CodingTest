package inflearn_CT.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_CT8_2 {

    int[] dis = {1,-1,5};
    int[] check = new int[10001];
    Queue<Integer> Q = new LinkedList<Integer>();

    public int BFS(int s, int e){
        check[s] = 1;
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                int x = Q.poll();
                for(int j=0;j<3;j++){
                    int nx = x+dis[j];
                    if(nx == e) return L+1;
                    if(check[nx]==0 && nx>=1 && nx <= 10000){
                        check[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }


        return 0;
    }

    public static void main(String[] args) {
        BFS_CT8_2 T = new BFS_CT8_2();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.BFS(s,e));
    }

}
