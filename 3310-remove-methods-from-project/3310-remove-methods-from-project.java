class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] inv : invocations) adj.get(inv[0]).add(inv[1]);

        boolean[] sus = new boolean[n];
        sus[k] = true;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(k);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : adj.get(cur)) {
                if (!sus[nxt]) { sus[nxt] = true; q.add(nxt); }
            }
        }

        boolean canRemove = true;
        for (int[] inv : invocations) {
            if (!sus[inv[0]] && sus[inv[1]]) { canRemove = false; break; }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (canRemove ? !sus[i] : true) ans.add(i);
        }
        return ans;
    }
}