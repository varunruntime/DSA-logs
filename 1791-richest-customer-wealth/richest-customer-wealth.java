class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for (int person = 0; person < accounts.length; person++){
            int sum = 0;
            for (int bank = 0; bank < accounts[person].length; bank++){
                sum += accounts[person][bank];
            }
            if (sum > ans){
                ans = sum;
            }
        }
        return ans;
    }
}