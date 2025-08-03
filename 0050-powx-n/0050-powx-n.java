class Solution {
    private double calculate(double x, long n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        double answer = 1;
        double half = calculate(x, n / 2);
        if(n % 2 == 1) answer = x;
        return answer * half * half;
    }
    public double myPow(double x, int n) {
        double answer = 1;
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        answer = calculate(x, N);
        return answer;
    }
}