import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        // 좌표,증감량을 담을 자료
        List<int[]> point = new ArrayList<>();
        for(int[] line : lines) {
            int x = line[0];
            int y = line[1];
            
            point.add(new int[]{x,+1});
            point.add(new int[]{y,-1});
        }
        // x좌표 기준 정렬
        point.sort((p,q) -> Integer.compare(p[0],q[0]));
        int cur = 0;
        
        // 슬라이딩윈도우처럼 탐색
    for(int i = 0; i < point.size()-1; i++) {
        cur += point.get(i)[1];
        if(cur >= 2) {
            answer += point.get(i+1)[0] - point.get(i)[0];
        }
    }
        
        return answer;
    }
}