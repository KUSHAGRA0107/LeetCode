class Solution {
    public int maxChunksToSorted(int[] arr) {
        int prefixSum = 0,chunk = 0,sortedSum = 0;
        int size = arr.length; 
        for(int i = 0;i < size ;i++){
            prefixSum += arr[i];
            sortedSum += i;

            if(sortedSum == prefixSum)chunk++; 
        }
        return chunk;
    }
}