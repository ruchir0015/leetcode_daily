class Solution {
    public boolean isPalindromic(String s) {
        int n = s.length() * 8;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int char1 = s.charAt(i / 8);
            int char2 = s.charAt(j / 8);
            int bit1 = (char1 >> (7 - i % 8)) & 1;
            int bit2 = (char2 >> (7 - j % 8)) & 1;
            if (bit1 != bit2) return false;
        }
        return true;
    }
}