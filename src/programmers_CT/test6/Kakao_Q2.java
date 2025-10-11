package programmers_CT.test6;

public class Kakao_Q2 {
    public int solution(int[][] signals){
       final int MAX_SEARCH_TIME = 500000;

       for (int i = 1; i < MAX_SEARCH_TIME; i++) {
           boolean allY = true;
           for (int[] light : signals) {
               int g = light[0];
               int y = light[1];
               int r = light[2];
               int cycle = g + y + r;

               int timeCycle = i % cycle;
               if (timeCycle == 0) timeCycle = cycle;

               if (!(timeCycle > g && timeCycle <= g+y)){
                   allY = false;
                   break;
               }
           }

           if (allY) return i;
       }

       return -1;
    }
}
