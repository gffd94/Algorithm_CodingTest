package programmers_CT.test4;
import java.util.*;

public class ProgrammersTest3_1 {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int lux = 51;
        int luy = 51;
        int rdx = 0;
        int rdy = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }

        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx + 1;
        answer[3] = rdy + 1;

        return answer;
    }
}
