package org.example;

 import java.util.HashMap;

class EfficientTwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        EfficientTwoSumSolution twoSumSolution = new EfficientTwoSumSolution();
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] result = twoSumSolution.twoSum(numbers,target);
        System.out.println(result[0]+" "+result[1]);
    }
}