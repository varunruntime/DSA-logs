class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        int n = nums.size();

        long long sum = 0;
        for(int st = 0; st < n; st++){
            long long range = 0;
            int maxi = nums[st];
            int mini = nums[st];
            for(int en = st; en < n; en++){
                maxi = max(maxi, nums[en]);
                mini = min(mini, nums[en]);
                range += (maxi - mini);
            }
            sum += range;

        }
        return sum;
    }
};