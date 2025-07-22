package programmers_CT.test4;
import java.util.*;

public class ProgrammersTest3 {
    public int[] solution(String[] wallpaper) {
        // 모든 시작점과 끝점을 담는 배열
        String[] arr = new String[wallpaper[0].length()*wallpaper.length];
        String[] list = new String[2]; // 시작점과 끝점 저장하는 공간
        int[] answer = new int[4]; // 정답 배열

        int lux = 51; // 시작점은 50보다 클 수 없으므로 51로 선언해놓고 min 함수로 최솟값을 찾음
        int luy = 51;
        int rdx = 0; // 끝점은 1보다 작을 수 없으므로 0으로 선언해놓고 max 함수로 최댓값을 찾음
        int rdy = 0;
        int cnt = 0; // #의 개수 세기

        for (int i=0; i<wallpaper.length; i++){
            for (int j=0; j<wallpaper[0].length(); j++){
                if (wallpaper[i].charAt(j)=='#'){
                    arr[cnt]=i+","+j; // #이 있는 좌표값만 모으고 위치 확인
                    cnt++; //
                }
                String arrList = arr[i];
                System.out.println("arr: "+arrList);
                System.out.println("cnt: "+cnt);
            }
        }

        for (int i=0; i<arr.length; i++){
            if (arr[i]!=null){
                list = arr[i].split(",");
            }
            int a = Integer.parseInt(list[0]);
            int b = Integer.parseInt(list[1]);
            lux = Math.min(lux,a);
            luy = Math.min(luy,b);
            rdx = Math.max(rdx,a);
            rdy = Math.max(rdy,b);
        }

        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx+1;
        answer[3] = rdy+1;



        return answer;
    }
}
