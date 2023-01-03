package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class two_sum {
    public static void main(String[] args) {
		
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 2, 4};
        int[] nums3 = {3, 3};
        int[] nums4 = {0, 4, 3, 0};

        int tg1 = 9;
        int tg2 = 6;
        int tg3 = 0;

        /*
        System.out.println("Case 1:");
        int[] result = solution(nums1, tg1);
        System.out.println("\nCase 2:");
        result = solution(nums2, tg2);
        System.out.println("\nCase 3:");
        result = solution(nums3, tg2);
        System.out.println("\nCase 4:");
        result = solution(nums4, tg3);
        */

        System.out.println("Case 1:");
        int[] result = betterSolution(nums1, tg1);
        System.out.println(Arrays.toString(result));

        System.out.println("\nCase 2:");
        result = betterSolution(nums2, tg2);
        System.out.println(Arrays.toString(result));

        System.out.println("\nCase 3:");
        result = betterSolution(nums3, tg2);
        System.out.println(Arrays.toString(result));

        System.out.println("\nCase 4:");
        result = betterSolution(nums4, tg3);
        System.out.println(Arrays.toString(result));

	}

    public static int[] solution(int[] nums, int target) {
        System.out.println("Target: " + target);
        int[] result = new int[2];
        boolean found = false;

        for(int i = 0; i < nums.length; i++) {
            for(int k = nums.length - 1; k > i; k--) {
                if(nums[i] + nums[k] == target) {
                    result[0] = i;
                    result[1] = k;
                }
            }
        }

        System.out.println("RESULT: " + Arrays.toString(result));

        return result;
    }

    public static int[] betterSolution(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {                         // go through array
            
            if (numToIndex.containsKey(target - nums[i])) {             // calculate the number to add to a current number 
                return new int[] {numToIndex.get(target - nums[i]), i}; //   to get target and look it up in hashmap
            }                                                           //   if present, get index and return

            numToIndex.put(nums[i], i);                                 // add value + index to hashmap
        }

        return new int[] {};    // placeholder
    }
    
}
