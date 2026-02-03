package programmers_CT.study;
import java.util.*;

public class PG_Lv1_92334 {
    public int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];

        // 누가 누구를 신고했는 가 (중복 제거)
        Map<String, Set<String>> reportMap = new HashMap<>();

        // 초기화: id_list에 있는 모든 사람에 대해 빈 Set을 미리 만들기.
        for(String id : id_list) {
            reportMap.put(id, new HashSet<>());
        }

        // reportMap에 어떤 사람이 누구를 신고했는지 입력
        for(int i = 0; i < report.length; i++){
            String[] parts = report[i].split(" ");
            String reporter = parts[0];
            String target = parts[1];

            reportMap.get(reporter).add(target);
        }

        // 누가 몇번 신고했는 가
        Map<String, Integer> countMap = new HashMap<>();

        // 초기화
        for(String id : id_list){
            countMap.put(id, 0);
        }

        // reportMap에 있는 Set을 가져와서 신고당한 사람들의 갯수를 세어줌
        for(String reporter : reportMap.keySet()){
            Set<String> targets = reportMap.get(reporter);
            for(String target : targets){
                countMap.put(target, countMap.get(target)+1);
            }
        }

        // k번 이상인 사람 찾기
        for(int i = 0; i < id_list.length; i++){
            String reporter = id_list[i]; // 현재 유저
            Set<String> targetUsers = reportMap.get(reporter); // 내가 신고한 사람들

            // 내가 신고한 사람들 중 k번 이상인 사람 있으면 +1
            for(String target : targetUsers){
                if(countMap.get(target) >= k){
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}
