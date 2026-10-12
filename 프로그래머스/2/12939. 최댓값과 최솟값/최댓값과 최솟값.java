import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int[] nums = Arrays.stream(s.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return min+" "+max;
    }
}