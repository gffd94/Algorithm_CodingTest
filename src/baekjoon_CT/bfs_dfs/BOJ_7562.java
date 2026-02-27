package baekjoon_CT.bfs_dfs;
import java.util.*;
import java.io.*;

class Node {
    int x, y, cnt;
    Node(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}


public class BOJ_7562 {

    static int[] dx = {-2, -2, 1, -1, 2, 2, 1, -1};
    static int[] dy = { 1, -1, 2,  2,-1, 1,-2, -2};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int I = Integer.parseInt(br.readLine());

            // 방문처리를 해서 무한 루프 하지 않도록
            boolean[][] visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());

            // 처음 시작과 목표지점이 같다면 더 할 필요 없이 (시간줄이기)
            if(curX == goalX && curY == goalY){
                System.out.println(0);
                continue;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(curX,curY,0));
            visited[curX][curY] = true;

            while(!queue.isEmpty()){
                Node cur = queue.poll();
                int x = cur.x;
                int y = cur.y;
                int cnt = cur.cnt;

                for(int j = 0; j < 8; j++){
                    int nextX = x + dx[j];
                    int nextY = y + dy[j];

                    if(nextX < 0 || nextX >= I || nextY < 0 || nextY >= I){
                        continue;
                    }

                    // 방문했던 곳이면 패스 하는 조건 추가!
                    if(visited[nextX][nextY]) continue;

                    // 탈출 조건
                    if(nextX == goalX && nextY == goalY){
                        System.out.println(cur.cnt+1);
                        queue.clear();
                        break;
                    }

                    visited[nextX][nextY] = true;
                    queue.add(new Node(nextX,nextY,cur.cnt+1));
                }
            }
        }


    }
}
