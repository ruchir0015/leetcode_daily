class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < target.length(); i++) {
            int ch = target.charAt(i) - 'a';

            if (freq[ch] > 0) {
                freq[ch]--;
                continue;
            }

            for (int j = i; j >= 0; j--) {

                if (j < i) {
                    freq[target.charAt(j) - 'a']++;
                }

                int cur = target.charAt(j) - 'a';

                for (int c = cur + 1; c < 26; c++) {

                    if (freq[c] > 0) {

                        StringBuilder ans =
                            new StringBuilder(target.substring(0, j));

                        ans.append((char) ('a' + c));

                        freq[c]--;

                        for (int x = 0; x < 26; x++) {
                            while (freq[x] > 0) {
                                ans.append((char) ('a' + x));
                                freq[x]--;
                            }
                        }

                        return ans.toString();
                    }
                }
            }

            return "";
        }

        for (int j = target.length() - 1; j >= 0; j--) {

            freq[target.charAt(j) - 'a']++;

            int cur = target.charAt(j) - 'a';

            for (int c = cur + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    StringBuilder ans =
                        new StringBuilder(target.substring(0, j));

                    ans.append((char) ('a' + c));

                    freq[c]--;

                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            ans.append((char) ('a' + x));
                            freq[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }
        return "";
    }
}