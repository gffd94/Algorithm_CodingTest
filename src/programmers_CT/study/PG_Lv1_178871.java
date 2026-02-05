package programmers_CT.study;
import java.util.*;

public class PG_Lv1_178871 {
    public String[] solution(String[] players, String[] callings) {

        // 이름 , 등수 로 Map 구조를 통해 빠르게 탐색
        Map<String, Integer> rankMap = new HashMap<>();

        // ("mumu" , 0) ("soe" , 1) ("poe" , 2) ("kai" , 3) ("mine" , 4)
        for(int i = 0; i< players.length; i++){
            rankMap.put(players[i], i);
        }

        //poe
        for(int i = 0; i< callings.length; i++){
            String name = callings[i];
            // player랑 rankMap을 같이 갱신
            int rank = rankMap.get(name); // 2
            String runner = players[rank-1]; //soe

            rankMap.put(name, rank-1); // poe, 1
            rankMap.put(runner, rank); // soe , 2
            players[rank-1] = name; // poe
            players[rank] = runner; // soe
        }


        return players;
    }
}
