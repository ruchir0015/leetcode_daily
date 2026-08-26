class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        for (int l = 0, c = 0, r = 0; r < s.length(); r++) {
            c += s.charAt(r) - '0';
            while (c > k || (l < r && s.charAt(l) == '0')) c -= s.charAt(l++) - '0';
            if (c == k) {
                String cur = s.substring(l, r + 1);
                if (ans.isEmpty() || cur.length() < ans.length() || (cur.length() == ans.length() && cur.compareTo(ans) < 0)) ans = cur;
            }
        }
        return ans;
    }
}