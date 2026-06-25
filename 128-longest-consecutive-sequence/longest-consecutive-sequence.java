import java.util.HashSet;

class Solution {

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;

        // Check each number
        for (int num : set) {

            // Start only if this is the beginning of a sequence
            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                // Count the consecutive sequence
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                if (count > longest) {
                    longest = count;
                }
            }
        }

        return longest;
    }
}