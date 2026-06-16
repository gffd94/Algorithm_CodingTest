import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        // A,B 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        // A,B idx 잡기
        int aIdx = 0;
        int bIdx = 0;
        // while문 돌면서 O(N) 탐색
        while(bIdx < B.length) {
            // B가 이길경우
            if(B[bIdx] > A[aIdx]) {
                answer++;
                bIdx++;
                aIdx++;
            } else {
            // B가 지거나 비기는 경우
             bIdx++;   
            }
        }
        
        return answer;
    }
}