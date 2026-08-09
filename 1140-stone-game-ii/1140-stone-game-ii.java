class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        int[][] dp = new int[n][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 1, suffixSum, dp, n);
    }

    private int solve(int i, int M, int[] suffixSum, int[][] dp, int n) {
        if (i == n)
            return 0;
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }

        if (dp[i][M] != -1)
            return dp[i][M];

        int best = 0;
        for (int X = 1; X <= 2 * M; X++) {
            int taken = suffixSum[i] - suffixSum[i + X]
                    + suffixSum[i + X] - solve(i + X, Math.max(M, X), suffixSum, dp, n);
            taken = suffixSum[i] - solve(i + X, Math.max(M, X), suffixSum, dp, n);
            best = Math.max(best, taken);
        }

        dp[i][M] = best;
        return best;
    }
}