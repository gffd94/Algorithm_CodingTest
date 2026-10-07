import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, 
                                    String op_end, String[] commands) {
        // 문자 -> int 형변환
        int vLen = toSeconds(video_len);
        int cur = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);
        
        // 시작하자마자 오프닝인지 체크
        cur = checkOpening(cur, opStart, opEnd);
        
        // 명령어 순차 처리 
        for(String cmd : commands) {
            
            if(cmd.equals("prev")) {
                cur = Math.max(0,cur-10);
            }else if(cmd.equals("next")) {
                cur = Math.min(cur+10, vLen);
            }
            
            // 이동 직후 오프닝 구간확인
            cur = checkOpening(cur, opStart, opEnd);
        }        
           
    
        // 출력 조건 대로 형변환
        return String.format("%02d:%02d",cur/60,cur%60);
        
    }
    
    // "mm:ss" -> 초단위 변환
    private int toSeconds (String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    // 오프닝 구간 체크
   private int checkOpening (int cur, int opStart, int opEnd) {
       if(opStart <= cur && cur <= opEnd) {
            return opEnd; 
       }
       return cur;
   }
}