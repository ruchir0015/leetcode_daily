class Solution {
  // prime index: 0->2, 1->3, 2->5, 3->7
  private static final int[][] FACTOR = {
      {0,0,0,0}, // 0
      {0,0,0,0}, // 1
      {1,0,0,0}, // 2
      {0,1,0,0}, // 3
      {2,0,0,0}, // 4
      {0,0,1,0}, // 5
      {1,1,0,0}, // 6
      {0,0,0,1}, // 7
      {3,0,0,0}, // 8
      {0,2,0,0}  // 9
  };

  public String smallestNumber(String num, long t) {
    int[] p = new int[4];
    int[] primesArr = {2, 3, 5, 7};
    for (int idx = 0; idx < 4; idx++) {
      int prime = primesArr[idx];
      while (t % prime == 0) {
        t /= prime;
        p[idx]++;
      }
    }
    if (t != 1) return "-1";

    int[] digitCounts = new int[10];
    int totalNeeded = getFactorCount(p, digitCounts);
    int n = num.length();

    if (totalNeeded > n) {
      char[] res = new char[totalNeeded];
      fillDigits(res, 0, digitCounts);
      return new String(res);
    }

    char[] numArr = num.toCharArray();
    int[] prefix = new int[4];
    int firstZeroIndex = -1;
    for (int i = 0; i < n; i++) {
      int d = numArr[i] - '0';
      if (d == 0 && firstZeroIndex == -1) firstZeroIndex = i;
      for (int k = 0; k < 4; k++) prefix[k] += FACTOR[d][k];
    }

    if (firstZeroIndex == -1) {
      firstZeroIndex = n;
      if (isSubset(p, prefix)) return num;
    }

    for (int i = n - 1; i >= 0; i--) {
      int d = numArr[i] - '0';
      for (int k = 0; k < 4; k++) prefix[k] -= FACTOR[d][k];

      int spaceAfter = n - 1 - i;
      if (i > firstZeroIndex) continue;

      for (int biggerDigit = d + 1; biggerDigit <= 9; biggerDigit++) {
        int[] needed = new int[4];
        for (int k = 0; k < 4; k++) {
          int tmp = p[k] - prefix[k];
          if (tmp < 0) tmp = 0;
          tmp -= FACTOR[biggerDigit][k];
          if (tmp < 0) tmp = 0;
          needed[k] = tmp;
        }
        int[] repl = new int[10];
        int replSum = getFactorCount(needed, repl);
        if (replSum <= spaceAfter) {
          int fillOnes = spaceAfter - replSum;
          char[] ans = new char[n];
          System.arraycopy(numArr, 0, ans, 0, i);
          ans[i] = (char) ('0' + biggerDigit);
          int pos = i + 1;
          for (int j = 0; j < fillOnes; j++) ans[pos++] = '1';
          fillDigits(ans, pos, repl);
          return new String(ans);
        }
      }
    }

    int[] ext = new int[10];
    int extSum = getFactorCount(p, ext);
    int newLen = n + 1;
    char[] ans = new char[newLen];
    int ones = newLen - extSum;
    int pos = 0;
    for (int j = 0; j < ones; j++) ans[pos++] = '1';
    fillDigits(ans, pos, ext);
    return new String(ans);
  }

  private int getFactorCount(int[] count, int[] out) {
    int count8 = count[0] / 3;
    int remaining2 = count[0] % 3;
    int count9 = count[1] / 2;
    int count3 = count[1] % 2;
    int count4 = remaining2 / 2;
    int count2 = remaining2 % 2;
    int count6 = 0;
    if (count2 == 1 && count3 == 1) { count2 = 0; count3 = 0; count6 = 1; }
    if (count3 == 1 && count4 == 1) { count2 = 1; count6 = 1; count3 = 0; count4 = 0; }
    int count5 = count[2];
    int count7 = count[3];

    out[2] = count2; out[3] = count3; out[4] = count4; out[5] = count5;
    out[6] = count6; out[7] = count7; out[8] = count8; out[9] = count9;

    return count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9;
  }

  private void fillDigits(char[] arr, int pos, int[] digitCounts) {
    for (int d = 2; d <= 9; d++) {
      int c = digitCounts[d];
      for (int j = 0; j < c; j++) arr[pos++] = (char) ('0' + d);
    }
  }

  private boolean isSubset(int[] need, int[] have) {
    for (int k = 0; k < 4; k++)
      if (have[k] < need[k]) return false;
    return true;
  }
}