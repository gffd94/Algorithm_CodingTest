class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        if(N == 1 && M == 1) return 0;
        
        if( M%2 != 0 && N%2 != 0) {
            answer = M*N;
        }
        
        answer = M*N -1;
        return answer;
    }
}