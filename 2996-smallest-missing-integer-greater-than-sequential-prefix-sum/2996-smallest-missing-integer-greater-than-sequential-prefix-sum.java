class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) break;
            sum += nums[i];
        }

        boolean[] seen = new boolean[2501];
        for (int x : nums) seen[x] = true;

        while (seen[sum]) sum++;

        return sum;
    }
}