class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int size = arr.length;
        for(int i = 0; i < size - 2; i++){
            int product = arr[i] * arr[i + 1] * arr[i + 2];
            if(product % 2 == 1) return true;
        }
        return false;
    }
}