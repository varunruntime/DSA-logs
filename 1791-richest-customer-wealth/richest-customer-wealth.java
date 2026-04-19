class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE; 
        for(int person = 0; person < accounts.length; person++){ // for every person in accounts
            int sum = 0;
            for(int account = 0; account < accounts[person].length; account++){ // for every person bank accounts
                sum += accounts[person][account];
            }
            if(sum > ans){
                ans = sum;
            }

        }
        return ans;
    }
}