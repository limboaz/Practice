package array;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        int i, j;
        for (i = 0; i < nums.length; i++){
            for (j = i + 1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        int[] arr = {3,2,4};
        int[] re = twoSum(arr, 6);
        System.out.println(re[0]);
        System.out.println(re[1]);
    }
}
