import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
      
        for (int num : nums) {
            if (numCount.containsKey(num)) {
                return num;
            }
            numCount.put(num, 1);
        }

        return -1; 
    }
}