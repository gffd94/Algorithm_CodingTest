import java.util.*;
import java.io.*;

public class Main {

    static int N, r, c, d;
    static int[][] ocean;
    static boolean[][] visited;

    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};


    static int[][] priority = {
        {0, 0, 0, 0}, 
        {1, 3, 4, 2}, 
        {2, 4, 3, 1}, 
        {3, 2, 1, 4}, 
        {4, 1, 2, 3} 
    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        ocean = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());
            }
