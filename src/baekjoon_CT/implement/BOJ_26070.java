package baekjoon_CT.implement;
import java.util.*;
import java.io.*;

public class BOJ_26070 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 곰곰이들 (0 : 치킨, 1 : 피자, 2: 햄버거)
        long[] eating = new long[3];
        // 쿠폰
        long[] coupon = new long[3];
        for(int i = 0; i < 3; i++) {
            eating[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            coupon[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
        // (자기 꺼 쓰기 + 3배 넘기기) -> (3배 넘긴거 쓰기 -> 3배또 넘기기) = 2번
        for(int i = 0; i < 2; i++){

            // 쿠폰 사용
            for(int j = 0; j < 3; j++){
                if(coupon[j] == 0 || eating[j] == 0) continue;
                long total = Math.min(eating[j], coupon[j]); // 쿠폰,곰곰이 중에 더 작은거 total에 넣기
                answer += total;
                eating[j] -= total;
                coupon[j] -= total;
            }

            // 3배 넘기기 작업
            long[] temp = new long[3];
            for(int j = 0; j < 3; j++) {
                // 2. [수정] 내 옆사람이 안 먹더라도(eating == 0),
                //    다다음 사람을 위해 식권은 계속 넘겨줘야 함.
                //    따라서 eating 조건 삭제하고 coupon이 3보다 작을 때만 skip
                if(coupon[j] < 3) continue;
                // 쿠폰 생성
                temp[(j+1)%3] = coupon[j]/3;
                coupon[j] %= 3;
            }

            // 쿠폰 갱신
            for(int j = 0; j < 3; j++) {
                coupon[(j+1)%3] += temp[(j+1)%3];
            }
        }

        // 잔반처리
        for(int i = 0; i < 3; i++){
            long leave = Math.min(eating[i],coupon[i]);
            answer += leave;
        }

        System.out.println(answer);

    }
}
