class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        int len = A.length();
        // result 0인경우 미리 count
        if(A.equals(B)){
            return answer;
        }
        
        boolean flag = true;
        
        for(int i = 0 ; i < len; i++) {
            // 여기서 옮기는 작업
            String strB = A.substring(len-1);
            String strA = A.substring(0,len-1);
            
            String str = strB+strA;
            answer++;
            if(B.equals(str)){
                flag = false;
                break;    
            }
            
            A = str;
        }
        if(flag) {
            return -1;
        }
        
        return answer;
    }
}