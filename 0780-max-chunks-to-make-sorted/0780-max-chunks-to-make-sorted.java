class Solution {
    public int maxChunksToSorted(int[] arr) {
        int [] prefix = new int[arr.length];
        int [] suffix = new int[arr.length];
        prefix[0] = arr[0];
        suffix[arr.length - 1] = arr[arr.length - 1];
        int counter = 0;
        for(int i = 1;i < arr.length;i++){
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }

        for(int i = arr.length - 2;i >= 0;i--){
            suffix[i] = Math.min(suffix[i + 1], arr[i]);
        }

        for(int i = 0;i<arr.length;i++){
            if(i == 0 || suffix[i] > prefix[i - 1]){
                counter++;
            }
        }

        return counter;
    }
}