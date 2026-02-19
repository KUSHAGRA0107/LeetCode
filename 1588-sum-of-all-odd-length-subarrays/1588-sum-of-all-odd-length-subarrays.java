class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int size = arr.length;
        int currSize = 0, answer = 0;
        for(int i = 0; i < size; i++){
            int sum = 0;
            for(int j = i; j < size; j++){
                sum += arr[j];
                currSize = j - i + 1;
                if(currSize % 2 == 1) answer += sum;
            }
        }
        return answer;
    }
}