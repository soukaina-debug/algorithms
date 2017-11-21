// https://leetcode.com/problems/degree-of-an-array
// 
// Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
// 
// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
// 
// Example 1:
// Input: [1, 2, 2, 3, 1]
// Output: 2
// Explanation: 
// The input array has a degree of 2 because both elements 1 and 2 appear twice.
// Of the subarrays that have the same degree:
// [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
// The shortest length is 2. So return 2.
// Example 2:
// Input: [1,2,2,3,1,4,2]
// Output: 6
// Note:
// 
// nums.length will be between 1 and 50,000.
// nums[i] will be an integer between 0 and 49,999.
class Solution {
    public int findShortestSubArray(int[] nums) {
        int result = 1;
        int max = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int[] data = map.get(value);
            if (data != null) {
                data[1]++;
                map.put(value, data);
                if (data[1] == max) {
                    result = Math.min(i - data[0] + 1, result);
                } else if (data[1] > max) {
                    max = data[1];
                    result = i - data[0] + 1;
                }
            } else {
                map.put(nums[i], new int[]{i, 1});
            }
        }
        return result;
    }
}
