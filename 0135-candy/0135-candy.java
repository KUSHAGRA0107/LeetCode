class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int [] left = new int[size];
        int [] right = new int[size];
        left[0] = 1;
        right[size - 1] = 1;

        for(int i = 1; i < size; i++){
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
            else{
                left[i] = 1;
            }
        }

        for(int j = size - 2; j >= 0; j--){
            if(ratings[j] > ratings[j + 1]){
                right[j] = right[j + 1] + 1;
            }
            else{
                right[j] = 1;
            }
        }
        int answer = 0;
        for(int index = 0;index < size; index++){
            answer += Math.max(left[index], right[index]);
        }
        return answer;
           
    }
}