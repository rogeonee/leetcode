package easy;

public class binary_search {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int tg1 = 9;
        int tg2 = 2;

        int res = search(nums, tg1);
        System.out.println("Case 1, idx: " + res + "\n");
        res = search(nums, tg2);
        System.out.println("Case 2, idx: " + res + "\n");
    }

    public static int search(int[] nums, int target) {
        // array is sorted
        // check whether target is in first or second half of the array
        int mid = nums.length / 2;

        // if in the first half, start from the beginning, and vice versa
        if(nums[mid] > target) {
            for(int i = 0; i < nums.length; i++) {

                // xor elements with target, if xor = 0 => found
                if((nums[i]^target) == 0)
                    return i;
            }
        } else {
            for(int i = nums.length - 1; i >= 0 ; i--) {
                if((nums[i]^target) == 0)
                    return i;
            }
        }

        // otherwise, target is not in the array
        return -1;
    }
    
}
