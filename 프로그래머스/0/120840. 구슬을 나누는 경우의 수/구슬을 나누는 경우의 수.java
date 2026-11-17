class Solution {
    public int solution(int balls, int share) {
        int answer = 0;
        answer = comb(balls, share);
        return answer;
    }
    
    private int comb(int n, int r) {
        if(n==r || r==0) return 1;
        return comb(n-1, r-1) + comb(n-1, r);
    }
}