import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] pos = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = arr[i][0];
            pos[arr[i][1]] = i;
        }

        // farthest reachable to the right in one step
        int[] next = new int[n];
        int r = 0;
        for (int l = 0; l < n; l++) {
            if (r < l) r = l;
            while (r + 1 < n && values[r + 1] - values[l] <= maxDiff) {
                r++;
            }
            next[l] = r;
        }

        // farthest reachable to the left in one step
        int[] prev = new int[n];
        int l = 0;
        for (int i = 0; i < n; i++) {
            while (values[i] - values[l] > maxDiff) l++;
            prev[i] = l;
        }

        int LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        int[][] upRight = new int[LOG][n];
        int[][] upLeft = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            upRight[0][i] = next[i];
            upLeft[0][i] = prev[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                upRight[k][i] = upRight[k - 1][upRight[k - 1][i]];
                upLeft[k][i] = upLeft[k - 1][upLeft[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {
            int u = pos[queries[qi][0]];
            int v = pos[queries[qi][1]];

            if (u == v) {
                ans[qi] = 0;
                continue;
            }

            if (u < v) {
                if (next[u] == u) {
                    ans[qi] = -1;
                    continue;
                }

                int cur = u;
                int steps = 0;

                for (int k = LOG - 1; k >= 0; k--) {
                    if (upRight[k][cur] < v) {
                        if (upRight[k][cur] == cur) continue;
                        cur = upRight[k][cur];
                        steps += 1 << k;
                    }
                }

                if (next[cur] == cur) ans[qi] = -1;
                else ans[qi] = steps + 1;

            } else {
                if (prev[u] == u) {
                    ans[qi] = -1;
                    continue;
                }

                int cur = u;
                int steps = 0;

                for (int k = LOG - 1; k >= 0; k--) {
                    if (upLeft[k][cur] > v) {
                        if (upLeft[k][cur] == cur) continue;
                        cur = upLeft[k][cur];
                        steps += 1 << k;
                    }
                }

                if (prev[cur] == cur) ans[qi] = -1;
                else ans[qi] = steps + 1;
            }
        }

        return ans;
    }
}