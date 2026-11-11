import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        for(String dicStr : dic) {
            
            if(spell.length != dicStr.length()) continue;
            HashSet<Character> table = new HashSet<>();

            for(String sp : spell) {
                table.add(sp.charAt(0));
            }
            boolean flag = true;
            
            for(char dc : dicStr.toCharArray()) {
                if(table.contains(dc)) {
                    table.remove(dc);
                } else {
                    flag = false;
                    break;
                }
            }
            
            if(flag && table.isEmpty()) return 1;
        }
        return 2;
    }
}