class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push((y + x));
            } else if (s.equals("-")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push((y - x));
            } else if (s.equals("/")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push((y / x));
            } else if (s.equals("*")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push((y * x));
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return Integer.valueOf(stack.pop());
    }
}