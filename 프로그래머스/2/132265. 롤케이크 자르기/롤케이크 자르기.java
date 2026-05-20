import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // 왼쪽 
        Set<Integer> yb = new HashSet<>();
        // 오른쪽
        HashMap<Integer, Integer> ob = new HashMap<>();
        int len = topping.length;
        int count = 0;
        
        // 한쪽으로 저장하는 작업.
        for(int i = 0; i< len; i++) {
            ob.put(topping[i], ob.getOrDefault(topping[i],0)+1);
        }
        
        // yb , ob 자르는 작업.
        for(int i = 0; i< len-1; i++) {
            int topped = topping[i];
            
            //yb 쪽으로 add
            yb.add(topped);
            
            //ob 쪽에서 해당 토핑 수 -1
            ob.put(topped, ob.get(topped) - 1);
            // 만약 해당 토핑수 0 이면 key값 제거
            if(ob.get(topped) == 0) {
                ob.remove(topped);
            }
            
            // 두 형제 토핑 수 비교
            if(yb.size() == ob.size()) {
                count++;
            }
        }
        
        if(count > 0) {
            answer = count;
        } 
        
        return answer;
    }
}