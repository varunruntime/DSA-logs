import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        // Create a copy and sort it
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Store rank for each unique element
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        // Replace each element with its rank
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}