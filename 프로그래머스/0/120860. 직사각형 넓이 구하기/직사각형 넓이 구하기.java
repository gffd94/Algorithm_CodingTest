class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x1 = dots[0][0];
        int y1 = dots[0][1];
            
        int width = 0;
        int height = 0;
        
        for(int i = 0; i < dots.length; i++) {
            if(x1 != dots[i][0]) {
                width = Math.abs(dots[i][0] - x1);
            }
            
            if(y1 != dots[i][1]) {
                height = Math.abs(dots[i][1] - y1);
            }
        }
        
        answer = width * height;
            
        return answer;
    }
}