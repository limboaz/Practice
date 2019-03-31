package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    /*
    * Median is the middle value in an ordered integer list.
    * If the size of the list is even, there is no middle value.
    * So the median is the mean of the two middle value.

Examples:
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k
which is moving from the very left of the array to the very right.
You can only see the k numbers in the window.
Each time the sliding window moves right by one position.
Your job is to output the median array for each window in the original
array.*/
    public static double findMedian(int[] nums){
        //find the median of an array
        if(nums.length % 2 == 0){
            int size = nums.length/2 + 1;
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(size);
            for(int n: nums){
                queue.offer(n);
                if(queue.size() > size)
                    queue.poll();
            }

            int med_big = queue.peek();
            queue.poll();
            int med_small = queue.peek();
            long sum = (long)med_big + (long)med_small;
            double result = (double)sum / 2;
            return result;
        }else{
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>((nums.length+1) / 2);
            for(int n: nums){
                queue.offer(n);
                if(queue.size() > (nums.length+1) / 2)
                    queue.poll();
            }
            return queue.peek();
        }
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        for(int i = 0; i < nums.length - k + 1; i++){
            int[] curr = Arrays.copyOfRange(nums, i, i+k);
            medians[i] = findMedian(curr);
        }
        return medians;
    }

    public static void main(String[] args){
        int[] slide = {1,4};
        double [] result = medianSlidingWindow(slide, 2);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}
