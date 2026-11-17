class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int max = Math.max(sides[0],sides[1]);
        int min = Math.min(sides[0],sides[1]);
        
        int sum = sides[0] + sides[1];
        
        for(int i = 1; i < sum; i++) {
            if(i<= max) {
                if(max < i+min){
                    answer++;
                }
            } else {
                if(i < sum) answer++;
            }
        }
        
        return answer;
    }
}