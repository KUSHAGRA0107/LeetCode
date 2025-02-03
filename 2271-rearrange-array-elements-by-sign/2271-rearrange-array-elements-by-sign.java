class Solution {
    public int[] rearrangeArray(int[] nums) {
        int size = nums.length;
        int [] positive = new int[size/2];
        int [] negative = new int[size/2];
        int pindex = 0;
        int nindex = 0;

        for(int i = 0; i < size; i++){
            if(nums[i] < 0){
                negative[nindex] = nums[i];
                nindex++;
            }
            else{
                positive[pindex] = nums[i];
                pindex++;
            }
        }
        int index = 0;
        for(int i = 0; i < size/2; i++){
            nums[index] = positive[i];
            index++;
            nums[index] = negative[i]; 
            index++;
        }
        return nums;
    }
}