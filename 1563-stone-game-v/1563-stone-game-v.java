class Solution {
    int[][] dp;
    int[] prefix;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        dp = new int[n][n];
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
            Arrays.fill(dp[i], -1);
        }

        return solve(stoneValue, 0, n - 1);
    }

    public int solve(int[] st, int i, int j) {

        if (i >= j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = 0;

        for (int k = i; k < j; k++) {

            int left = prefix[k + 1] - prefix[i];
            int right = prefix[j + 1] - prefix[k + 1];

            if (left < right) {

                ans = Math.max(
                    ans,
                    left + solve(st, i, k)
                );

            } else if (right < left) {

                ans = Math.max(
                    ans,
                    right + solve(st, k + 1, j)
                );

            } else {

                ans = Math.max(
                    ans,
                    left + Math.max(
                        solve(st, i, k),
                        solve(st, k + 1, j)
                    )
                );
            }
        }
        return dp[i][j] = ans;
    }
}