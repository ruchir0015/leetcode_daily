class Solution {
    int dp[][];

    public int numDistinct(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        dp = new int[sl + 1][tl + 1];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return helper(s, t, sl, tl);
    }

    public int helper(String s, String t, int sl, int tl) {
        if (tl == 0)
            return dp[sl][tl] = 1;

        if (sl == 0)
            return dp[sl][tl] = 0;

        if (dp[sl][tl] != -1) {
            return dp[sl][tl];
        }

        if (s.charAt(sl - 1) == t.charAt(tl - 1)) {
            return dp[sl][tl] = helper(s, t, sl - 1, tl - 1) + helper(s, t, sl - 1, tl);
        } else {
            return dp[sl][tl] = helper(s, t, sl - 1, tl);
        }

    }
}