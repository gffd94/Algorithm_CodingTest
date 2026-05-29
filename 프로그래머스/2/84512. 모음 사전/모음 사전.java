import java.util.*;

class Solution {
    
    static String[] vowels = {"A", "E", "I", "O", "U"};
    static int count = 0;
    static int answer = 0;
    static boolean isFound = false; // 정답을 찾았는지 체크하는 플래그
    
    
public int solution(String word) {
        
        count = 0;
        answer = 0;
        isFound = false;
        
        // 빈 문자열("")부터 시작해서 글자를 하나씩 붙여 나갑니다.
        dfs("", word);
        
        return answer;
    }
    
    static void dfs(String current, String target) {
        // 이미 정답을 찾았다면 더 이상의 탐색은 생략하고 돌아갑니다 (가지치기)
        if (isFound) return;
        
        // 현재 만든 단어가 목표 단어와 일치하면 결과 저장 후 종료
        if (current.equals(target)) {
            answer = count;
            isFound = true;
            return;
        }
        
        // 길이가 5에 도달했다면 더 이상 글자를 붙일 수 없으므로 돌아갑니다.
        if (current.length() == 5) {
            return;
        }
        
        // A, E, I, O, U 순서대로 글자를 하나씩 붙여보며 깊어집니다.
        for (int i = 0; i < 5; i++) {
            count++; // 사전에 단어가 추가되는 순서이므로, dfs를 호출하기 전에 카운트를 올립니다.
            dfs(current + vowels[i], target);
        }
    }
}