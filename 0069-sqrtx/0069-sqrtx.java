class Solution {
    public int mySqrt(int x) {
        int result = (int)Math.exp(0.5 * Math.log(x));
        if ((long)(result + 1) * (result + 1) <= x) {
            result++;
        } else if ((long)result * result > x) {
            result--;                                        
        }
        return result;
    }
}