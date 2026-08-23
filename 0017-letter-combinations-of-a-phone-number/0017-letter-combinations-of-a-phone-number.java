class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, 0, "", ans, map);
        return ans;
    }

    void backtrack(String digits, int index, String curr, List<String> ans, String[] map) {
        if (index == digits.length()) {
            ans.add(curr);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            backtrack(digits, index + 1, curr + letters.charAt(i), ans, map);
        }
    }
}