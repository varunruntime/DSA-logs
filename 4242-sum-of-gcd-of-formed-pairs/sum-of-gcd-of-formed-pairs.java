import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];

        int prefixMax = 0;

        // Construct prefixGcd
        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);
            prefixGcd[i] = gcd(nums[i], prefixMax);
        }

        // Sort the array
        Arrays.sort(prefixGcd);

        long ans = 0;

        // Pair smallest with largest
        int left = 0, right = n - 1;
        while (left < right) {
            ans += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}