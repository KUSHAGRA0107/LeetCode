class Solution {
    public boolean allCapital(String word){
        for(int i = 0; i < word.length(); i++){
            if((int) word.charAt(i) >= 97) return false;
        }return true;
    }

    public boolean allSmall(String word){
        for(int i = 0; i < word.length(); i++){
            if((int) word.charAt(i) < 97) return false;
        }return true;
    }
    
    public boolean titleCase(String word){
        if((int) word.charAt(0) >= 97) return false;
        for(int i = 1; i < word.length(); i++){
            if((int) word.charAt(i) < 97) return false;
        }return true;
    }
    
    public boolean detectCapitalUse(String word) {
        return allCapital(word) || allSmall(word) || titleCase(word);
    }
}