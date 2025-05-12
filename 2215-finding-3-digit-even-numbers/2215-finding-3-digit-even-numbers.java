class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int size = digits.length;
        Set<Integer> answer = new HashSet<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    if(i == j || j == k || k == i) continue;
                    int digit = 100 * digits[i] + 10 * digits[j] + digits[k];
                    if(digit >= 100 && digit % 2 == 0){
                        answer.add(digit);
                    }
                }
            }
        }
        int [] result = new int[answer.size()];
        int index = 0;
        for(Integer element : answer){
            result[index] = element;
            index++;
        }
        Arrays.sort(result);
        return result;
    }
}