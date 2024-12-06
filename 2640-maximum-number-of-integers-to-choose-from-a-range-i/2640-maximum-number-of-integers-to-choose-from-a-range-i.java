class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0;i<banned.length;i++){
            set.add(banned[i]);
        }
        int counter = 0;
        int currSum = 0;
        // it is always optimum to select the number in ascending order,
        // as they will be the one that will give maximum output
        for(int i = 1; i <= n; i++){
            if(!set.contains(i)){
                if(currSum + i <= maxSum){
                    currSum += i;
                    counter += 1;
                }  
                else{
                    break;
                }
            }
        }
        return counter;
    }
}