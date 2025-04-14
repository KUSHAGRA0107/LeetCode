class Solution {
    public boolean isPredecessor(String word1, String word2){
        if(word2.length() - word1.length() != 1) return false;
        int i = 0;
        int j = 0;
        boolean skipped = false;
        while(i < word1.length() && j < word2.length()){
            if(word1.charAt(i) == word2.charAt(j)){
                i++;
                j++;
            }else{
                if(skipped == true) return false;
                skipped = true;
                j++;
            }
        }
        return true;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int size = words.length;
        int [] answer = new int[size];
        Arrays.fill(answer,1);
        int result = 1;
        for(int i = 1; i < size; i++){
            for(int prev = 0; prev < i; prev++){
                if(isPredecessor(words[prev], words[i])){
                    answer[i] = Math.max(answer[i], answer[prev] + 1);
                }
            }
            result = Math.max(result, answer[i]);
        }
        return result;
    }
}