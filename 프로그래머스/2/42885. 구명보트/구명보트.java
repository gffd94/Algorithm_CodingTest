import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        // 작은수 ~ 큰수 까지 정렬 후 양 끝의 합을 limit과 비교
        int lt = 0;
        int rt = people.length-1;
        while(lt<=rt){
            // 가장 작은, 큰수 합 <= 제한 무게일 때 count++
            if(people[lt] + people[rt] <= limit){
                answer++;
                lt++;
                rt--;
            }else {
                // 둘 합이 제한 무게보다 클땐 큰 무게만 count++;
                answer++;
                rt--;
            }
        }
        
        
        return answer;
    }
}