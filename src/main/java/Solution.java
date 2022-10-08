public class Solution {
    public int mySqrt(int x) {
        // using long to prevent overflow
        long left = 0;
        long right = (x / 2) + 1;

        while (left < right) {
            // binary search
            // + 1 targets the UPPER mid value
            long mid = left + (right - left) / 2 + 1;
            long square = mid * mid;

            // the mid value is the square root of x
            if (square == x) {
                return (int) mid;
            }

            // square value of mid is less than x
            // this may or may not be our answer
            // answer = highest possible square value that does not exceed x
            else if (square < x) {
                left = mid;
            }

            // square value is greater than x
            // we need to look leftward for a smaller number
            else {
                right = mid - 1;
            }
        }
        // because we used long, cast to int
        return (int) left;
    }
}
