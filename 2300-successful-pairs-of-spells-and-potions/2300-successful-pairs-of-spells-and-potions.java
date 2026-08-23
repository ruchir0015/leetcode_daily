class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long need = (success + spells[i] - 1) / spells[i];

            int l = 0, r = potions.length - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (potions[mid] >= need) r = mid - 1;
                else l = mid + 1;
            }

            ans[i] = potions.length - l;
        }

        return ans;
    }
}