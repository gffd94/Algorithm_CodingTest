import java.util.*;

class Solution {
    class Node implements Comparable<Node>{
        int div, val;
        
        public Node(int div, int val) {
            this.div = div;
            this.val = val;
        }
        
        @Override
        public int compareTo(Node o) {
            if(o.div == this.div) {
                return o.val - this.val;
            }
            
            return this.div - o.div;
        }
        
        
    }
    
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        List<Node> dvlist = new ArrayList<>();
        for(int i = 0; i < numlist.length; i++) {
            int d = Math.abs(n-numlist[i]);
            int v = numlist[i];
            
            dvlist.add(new Node(d,v));
        }
        
       Collections.sort(dvlist);
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = dvlist.get(i).val;
        }
        
        return answer;
    }
}