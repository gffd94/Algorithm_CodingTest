import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> table = new HashMap<>();
        
        for(int i = 0; i < array.length; i++) {
            table.put(array[i],table.getOrDefault(array[i],0)+1);    
        }
        
        int max = 0;
        int maxCount = 0;
        for(Map.Entry<Integer, Integer> entry : table.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            if(value > max) {
                answer = key;
                max = value;
                maxCount = 1;
            } else if(value == max) {
                maxCount++;
            } 
            
        }
        
        if(maxCount > 1) {
            answer = -1;
        }
        
        return answer;
    }
}