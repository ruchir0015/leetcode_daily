class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) f[c - 'a']++;

        char mid = 0;
        for (int i = 0; i < 26; i++)
            if (f[i] % 2 == 1) {
                if (mid != 0) return "";
                mid = (char) ('a' + i);
                f[i]--;
            }

        int half = s.length() / 2;
        for (int i = 0; i < half; i++) f[target.charAt(i) - 'a'] -= 2;

        if (valid(f)) {
            String head = target.substring(0, half);
            String tail = (mid == 0 ? "" : String.valueOf(mid)) + new StringBuilder(head).reverse();
            if (tail.compareTo(target.substring(half)) > 0) return head + tail;
        }

        for (int i = half - 1; i >= 0; i--) {
            f[target.charAt(i) - 'a'] += 2;
            if (!valid(f)) continue;
            for (int j = target.charAt(i) - 'a' + 1; j < 26; j++) {
                if (f[j] == 0) continue;
                f[j] -= 2;
                StringBuilder head = new StringBuilder(target.substring(0, i)).append((char) ('a' + j));
                for (int k = 0; k < 26; k++)
                    for (int m = 0; m < f[k] / 2; m++) head.append((char) ('a' + k));
                String rev = new StringBuilder(head).reverse().toString();
                return mid == 0 ? head.toString() + rev : head + String.valueOf(mid) + rev;
            }
        }
        return "";
    }

    boolean valid(int[] f) {
        for (int v : f) if (v < 0) return false;
        return true;
    }
}