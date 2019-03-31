package array;

public class removeDuplicates {
    public static int removeDuplicates(int[] nums){
        int i = 0;
        int cnt = 0;
        while (i < (nums.length-1)){
            if (nums[i] < nums[i+1]){
                cnt ++;
                i++;
            } else {
                int j;
                for (j = i; j < (nums.length - 1); j ++){
                    nums[j] = nums[j+1];
                }
                i++;
            }
        }
        if ( nums[nums.length-1] > nums[nums.length-2])
            cnt++;
        return cnt;
    }

    public static void main(String[] args){
        int [] arr = {0,0,1,1,1,2,2,3,3,4};
        int count = removeDuplicates(arr);
        int i;
        for (i=0; i < count; i++){
            System.out.println(arr[i]);
        }
    }
}
