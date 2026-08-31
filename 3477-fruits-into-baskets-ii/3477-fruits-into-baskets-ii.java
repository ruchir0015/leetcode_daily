class Solution {
    int seg[];
    public void build(int i, int l, int r, int[] b) {
        if (l == r) {
            seg[i] = b[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * i + 1, l, mid, b);
        build(2 * i + 2, mid + 1, r, b);
        seg[i] = Math.max(seg[2 * i + 1], seg[2 * i + 2]);
    }
    public boolean query(int i, int l, int r, int val) {
        if (seg[i] < val)  return false;
        if (l == r) {
            seg[i] = 0;
            return true;
        }
        int mid = l + (r - l) / 2;
        boolean placed = false;
        if (seg[2 * i + 1] >= val) placed = query(2 * i + 1, l, mid, val);
        else placed = query(2 * i + 2, mid + 1, r, val);
        seg[i] = Math.max(seg[2 * i + 1], seg[2 * i + 2]);
        return placed;
    }
    public int numOfUnplacedFruits(int[] f, int[] b) {
        int n = f.length;
        seg = new int[4 * n];
        build(0, 0, n - 1, b);
        int unoccupied = 0;
        for (int i : f) {
            if (query(0, 0, n - 1, i) == false) {
                unoccupied++;
            }
        }
        return unoccupied;
    }
}