class Solution {
    public int longestSubsequence(int[] nums) {

        int n = nums.length;
        int xor = 0;
        boolean foundNonZero = false;

        for(int num : nums)  {

            if(num != 0) foundNonZero = true;
            xor ^= num;
        }

        if(!foundNonZero) return 0;
        else if(xor != 0) return n;
        else return n - 1;
        
    }
}