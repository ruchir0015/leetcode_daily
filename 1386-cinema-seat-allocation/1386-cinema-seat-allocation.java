class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);

        int i = 0;
        int rowsUsed = 0;
        int m = reservedSeats.length;
        int max = 0;

        while (i < m) {

            int row = reservedSeats[i][0];
            rowsUsed++;

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            while (i < m && reservedSeats[i][0] == row) {
                int seat = reservedSeats[i][1];

                if (seat >= 2 && seat <= 5) left = false;
                if (seat >= 4 && seat <= 7) middle = false;
                if (seat >= 6 && seat <= 9) right = false;
                i++;
            }

            if (left && right) max += 2;
            else if (left || right || middle) max += 1;
            
        }

        return max + (n - rowsUsed) * 2;

    }
}