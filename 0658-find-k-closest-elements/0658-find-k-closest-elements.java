class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pivot_point = 0;
        int min_absolute_difference = x + Arrays.stream(arr).max().getAsInt();
        int size = arr.length;
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < size; i++){
            if(Math.abs(x - arr[i]) < min_absolute_difference){
                min_absolute_difference = Math.abs(x - arr[i]);
                pivot_point = i;
            }
        }
        answer.add(arr[pivot_point]);
        k--;
        int left = pivot_point - 1;
        int right = pivot_point + 1;

        while(k != 0){
            if(left < 0){
                answer.add(arr[right]);
                right++;
            }else if(right >= size){
                answer.add(arr[left]);
                left--;
            }else if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                answer.add(arr[left]);
                left--;
            }else{
                answer.add(arr[right]);
                right++;
            }
            k--;
        }
        Collections.sort(answer);
        return answer;
    }
}