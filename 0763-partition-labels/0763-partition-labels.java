class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> resultant = new ArrayList<>();
        int [] lastIndex = new int[26];
        int partitionStart = 0, partitionEnd = 0;
        for(int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < s.length(); i++){
            partitionEnd = Math.max(partitionEnd,
            lastIndex[s.charAt(i) - 'a']);

            if(partitionEnd == i){
                resultant.add(i - partitionStart + 1);
                partitionStart = i + 1;
            }
        }
        return resultant;
    }
}