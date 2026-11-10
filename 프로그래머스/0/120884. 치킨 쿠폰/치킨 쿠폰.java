class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int remain = 0;
        int div = 0;
        while(chicken / 10 != 0) {
            div = chicken/10;
            answer += div;
            remain = chicken%10;
            chicken = div + remain;
        }
        return answer;
    }
}