import java.util.*;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        Map<String, String> table = new HashMap<>();
        
        table.put(id_pw[0],id_pw[1]);
        
        for(String[] dbParts : db){
            String id = dbParts[0];
            String pw = dbParts[1];
            
            if(table.containsKey(id) && table.get(id).equals(pw)) {
                return "login";
            } else if(table.containsKey(id) && !table.get(id).equals(pw)){
                return "wrong pw";
            } 
             
            
        }
        
        
        return "fail";
    }
}