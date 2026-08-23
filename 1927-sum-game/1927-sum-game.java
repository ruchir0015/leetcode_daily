class Solution {
    public boolean sumGame(String num) {
        int mid = num.length() / 2, leftSum = 0, rightSum = 0, leftQ = 0, rightQ = 0;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c == '?') { if (i < mid) leftQ++; else rightQ++; }
            else { if (i < mid) leftSum += c - '0'; else rightSum += c - '0'; }
        }

        if ((leftQ + rightQ) % 2 != 0) return true;
        return 2 * (leftSum - rightSum) != 9 * (rightQ - leftQ);
    }
}