class Solution {
    public boolean isPalindrome(String s) {
        return helper(s, 0, s.length() - 1);
    }
    public boolean helper(String s, int left, int right) {
        if (left >= right) return true;
        
        char l = s.charAt(left);
        char r = s.charAt(right);
        
        if (!Character.isLetterOrDigit(l)) return helper(s, left + 1, right);
        if (!Character.isLetterOrDigit(r)) return helper(s, left, right - 1);
        
        if (Character.toLowerCase(l) != Character.toLowerCase(r)) return false;
        
        return helper(s, left + 1, right - 1);
    }
}