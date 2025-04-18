class Solution {
    public String smallestPalindrome(String s) {
        int [] frequency = new int[26];
        Arrays.fill(frequency,0);
        for(int i = 0; i < s.length(); i++){
            frequency[s.charAt(i) - 97]++;
        }
        char [] answer = new char[s.length()];
        int i = 0;
        int j = s.length() - 1;
        for(int idx = 0; idx < 26; idx++){
            int freq = frequency[idx];
            while(freq > 1){
                answer[i] = (char) (idx + 97);
                answer[j] = (char) (idx + 97);
                freq -= 2;
                i++;j--;
            }
        }
        for(int idx = 0; idx < 26; idx++){
            if(frequency[idx] % 2 == 1){
                answer[i] = (char)(idx + 97);
            }
        }
        StringBuilder string = new StringBuilder("");
        for(int index = 0; index < answer.length;index++){
            string.append(answer[index]);
        }
        return string.toString();
    }
}