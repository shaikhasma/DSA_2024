/** Striver SDE Sheet Challenge By Asma
 Problem : Two Sum
 Approach : Using Hashing
 */

import java.util.HashMap;
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            int second = target - nums[i];
            if(map.containsKey(second)){
                ans[0] = i;
                ans[1] = map.get(second);
                return ans;
            }else{
                map.put(nums[i],i);
            }
        }
        return ans;
    }
}
/**
 TC : 0(N)
 SC : 0(N)
 */

