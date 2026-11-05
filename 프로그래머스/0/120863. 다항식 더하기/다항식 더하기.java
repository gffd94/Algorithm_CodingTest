class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] parts = polynomial.split("\\+");
        
        int sNum = 0;
        int xNum = 0;
        
        for(String part : parts) {
            part = part.trim();
            if(part.contains("x")){
                // x로 들어온경우
                if(part.equals("x")){
                    xNum += 1;
                } else {
                    int idx = part.indexOf("x");
                    xNum += Integer.parseInt(part.substring(0,idx));
                }
            } else {
                sNum += Integer.parseInt(part);
            }
        }
        
        // x 항이 1인경우
        String xStr = "";
        if(xNum > 0) {
            if(xNum == 1) {
                xStr = "x";
            } else {
                xStr = xNum+"x";
            }
        }
        
        // 둘다 항이 있을 때
        if(xNum > 0 && sNum > 0) {
            answer = xStr+" + "+sNum;
        } else if(xNum == 0 && sNum > 0) {
            // 상수 항만 있을 때
            answer = sNum+"";
        } else if(xNum > 0 && sNum == 0) {
            // x항만 있을 때
            answer = xStr;
        }
        
        
        return answer;
    }
}