package programmers_CT.study;
import java.util.*;

public class PG_Lv2_1844 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public int solution(int[][] maps){

        // 갈수있는 방향(좌표)을 queue에 저장
        Queue<int[]> queue = new LinkedList<>();
        // 큐에 저장할 좌표와 거리 저장
        queue.add(new int[]{0,0,1});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int answer = cur[2];
            maps[0][0] = 0;

            for(int i = 0; i < 4; i++){
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if(nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length || maps[nextX][nextY] == 0){
                    continue;
                }

                // 목적지 (n-1)(m-1)에 도달했을 때 거리를 반환
                if(nextX == maps.length-1 && nextY == maps[0].length-1){
                    return answer+1;
                }

                maps[nextX][nextY] = 0;
                queue.add(new int[]{nextX,nextY,answer+1});

            }
        }

        return -1;

    }
}
