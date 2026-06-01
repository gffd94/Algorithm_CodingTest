import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Set<Integer> rentshop = new TreeSet<>();
        Set<Integer> buy = new TreeSet<>();
        
        for(int x : reserve) {
            rentshop.add(x);
        }
        
        for(int x : lost) {
            buy.add(x);
        }
        
        List<Integer> toRemove = new ArrayList<>();
        // 여분있는 학생이 잃어버린 경우
        for(int y : lost){
            if(rentshop.contains(y)) {
                toRemove.add(y);
            }

        }
        
        buy.removeAll(toRemove);
        rentshop.removeAll(toRemove);
        
        toRemove = new ArrayList<>();
        
        // lost 빌려줄 수 있는지 체크
        for(int b : buy) {
            
            if(rentshop.contains(b-1)){
                toRemove.add(b);
                rentshop.remove(b-1);
            } else if(rentshop.contains(b+1)){
                toRemove.add(b);
                rentshop.remove(b+1);
            }
        }
        
        buy.removeAll(toRemove);
        
        answer = n - buy.size();
        
        return answer;
        
    }
}