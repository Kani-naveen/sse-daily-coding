package org.example;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int target = 9;
        int[] nums = {1,4,5,6,4,6,7};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length;i++){
            int cur = nums[i];
            //cur + x = target
            //x = target - cur
            int x = target - cur;
            if(map.containsKey(x)){
                int[] result = {map.get(x),i};
                System.out.println(result[0]+" "+result[1]);

            }
            map.put(cur,i);
        }

    }
}
