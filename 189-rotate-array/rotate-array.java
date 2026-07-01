class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;

        // Storing thr last k elements
        int[] temp = new int[k];
        for(int i = 0; i < k; i++){
            temp[i] = nums[n - k + i];
        }

        // Shifting the remaining elements to the right
        for (int i = n - k - 1; i >= 0; i--){
            nums[i + k] = nums[i];
        } 

        // saved the begining elements
        for(int i = 0; i < k; i++){
            nums[i] = temp[i];
        }
    }
}