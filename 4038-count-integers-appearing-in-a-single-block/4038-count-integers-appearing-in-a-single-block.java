class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, Integer> block = new HashMap<>();
        for (int i = 0; i < nums.length; i++) if (i == 0 || nums[i] != nums[i - 1])  block.put(nums[i], block.getOrDefault(nums[i], 0) + 1);
        int ans = 0;
        for (int x : block.keySet()) if (block.get(x) == 1) ans++;
        return ans;
    }
}