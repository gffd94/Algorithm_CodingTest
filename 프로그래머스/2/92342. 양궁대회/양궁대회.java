import java.util.*;

class Solution {
    
    static int maxdiff;
    static int[] answer;
    
    public int[] solution(int n, int[] info) {
        maxdiff = -1;
        answer = new int[]{};
        
        int[] lion = new int[11];
        
        dfs(0, n, lion, info);
        
        if(answer.length == 0 || maxdiff <= 0) {
            return new int[]{-1};
        }
        
        return answer;
    }
    
    static void dfs (int index, int remaining, int[] lion, int[] info) {
        // 종료조건
        if(index == 10) {
            lion[10] = remaining;
            int diff = calcScore(lion, info);
            
             // 점수차가 더 좋으면
            if(diff > maxdiff) {
                maxdiff = diff;
                answer = lion.clone();
            }
            // 동점일 때 더 낮은 점수를 더 많이 쏴야함
            else if(diff == maxdiff && answer.length != 0) {
                    
                    for(int i = 10; i>=0; i--){
                        if(answer[i] > lion[i]) {
                            break;
                        }else if(lion[i] > answer[i]){
                            answer = lion.clone();
                            break;
                        }
                    }    
                
            }   
            
             lion[10] = 0;      // 복원!
             return;
        }
        
        // 이기기
        if(remaining >= info[index]+1) {
            lion[index] = info[index]+1;
            dfs(index+1, remaining -(info[index]+1), lion, info);
            lion[index] = 0;
        }
        
        // 포기
        dfs(index + 1, remaining, lion, info);
    }
    
    // 최종 점수계산 ( 음수 : -1, 양수면 제출)
    static int calcScore(int[] lion, int[] info) {
        int lionScore = 0, apeachScore = 0;
        for(int i = 0; i < 11; i++) {
            int price = 10 - i;
            // 점수 획득
            if(lion[i] > info[i]) {
                lionScore += price;
            } else if(info[i] > 0) {
                apeachScore += price;
            }
        }
        
        return lionScore - apeachScore;
    }
    
    
}