class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) {
            if (x > max) max = x;
        }

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        // cntDiv[d] = how many numbers are divisible by d
        int[] cntDiv = new int[max + 1];
        for (int d = 1; d <= max; d++) {
            for (int multiple = d; multiple <= max; multiple += d) {
                cntDiv[d] += freq[multiple];
            }
        }

        // exactPairs[d] = number of pairs whose gcd is exactly d
        long[] exactPairs = new long[max + 1];

        for (int d = max; d >= 1; d--) {
            long cnt = cntDiv[d];
            long pairs = cnt * (cnt - 1) / 2;

            for (int multiple = d * 2; multiple <= max; multiple += d) {
                pairs -= exactPairs[multiple];
            }

            exactPairs[d] = pairs;
        }

        // prefix[i] = total pairs having gcd <= i
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exactPairs[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1; // convert 0-based index to 1-based count

            int lo = 1, hi = max;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (prefix[mid] >= target) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            ans[i] = lo;
        }

        return ans;
    }
}