import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int idx = 0;
        
        int[] oneCheck = {1,2,3,4,5};
        int[] twoCheck = {2,1,2,3,2,4,2,5};
        int[] threeCheck = {3,3,1,1,2,2,4,4,5,5};
        
        int one = 0;
        int two = 0;
        int three = 0;
        
        while(idx < answers.length) {
            int num = answers[idx];
            
          
                int oneIdx = idx%oneCheck.length;
                if(num == oneCheck[oneIdx]){
                    one++;
                }
           
            
           
                int twoIdx = idx%twoCheck.length;
                if(num == twoCheck[twoIdx]){
                    two++;
                }
           
            
            
                int threeIdx = idx%threeCheck.length;
                if(num == threeCheck[threeIdx]){
                    three++;
                }
          
            
            idx++;
        }
        
       int max = Integer.MIN_VALUE;
        max = Math.max(max , one);
        max = Math.max(max , two);
        max = Math.max(max , three);
        
        ArrayList<Integer> array = new ArrayList<>();
        
        if(max == one) {
            array.add(1);
        } 
        if(max == two) {
            array.add(2);
        }
        if(max == three){
            array.add(3);
        }            
        
        Collections.sort(array);
        
        
        
        return array.stream().mapToInt(i -> i).toArray();
    }
}