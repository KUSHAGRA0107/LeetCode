class Solution {
    public boolean isVowel(Character ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' ||  ch == 'u') return true;
        return false;
    }
    public long countOfSubstrings(String word, int k) {
        long validSubstring = 0;
        int size = word.length();
        HashMap<Character, Integer> vowel = new HashMap<>();
        int consonant = 0;
        int [] nextConsonant = new int[size];
        int nextConsonantIndex = size;
        for(int i = size - 1; i >= 0; i--){
            nextConsonant[i] = nextConsonantIndex;
            if(!isVowel(word.charAt(i))){
                nextConsonantIndex = i;
            }
        }

        int start = 0;
        int end = 0;

        while(end < size){
            Character ch = word.charAt(end);
            if(isVowel(ch)){
                vowel.put(ch, vowel.getOrDefault(ch, 0) + 1);
            }else{
                consonant++;
            }
            while(consonant > k){
                Character startCharacter = word.charAt(start);
                if(isVowel(startCharacter)){
                    vowel.put(startCharacter, vowel.get(startCharacter) - 1);
                    if(vowel.get(startCharacter) == 0){
                        vowel.remove(startCharacter);
                    }
                }else{
                    consonant--;
                }
                start++;
            }
            while(start < size && vowel.size() == 5 && consonant == k){
                validSubstring += nextConsonant[end] - end;
                Character startWord = word.charAt(start);
                if(isVowel(startWord)){
                    vowel.put(startWord, vowel.get(startWord) - 1);
                    if(vowel.get(startWord) == 0){
                        vowel.remove(startWord);
                    }
                }
                else{
                    consonant--;
                }
                start++;
            }
            end++;
        }
    return validSubstring;
    }
}