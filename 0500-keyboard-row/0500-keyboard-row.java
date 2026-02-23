class Solution {
    public boolean isPresent(String row, String word){
        int size = word.length();
        for(int i = 0; i < size; i++){
            char ch = word.charAt(i);
            boolean flag = false;
            for(int j = 0; j < row.length(); j++){
                if(row.charAt(j) == ch) flag = true;
            }
            if(!flag) return false;
        }return true;
    }

    public String[] findWords(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        int size = words.length;
        String row1 = "qwertyuiopQWERTYUIOP", row2 = "asdfghjklASDFGHJKL", row3 = "zxcvbnmZXCVBNM";
        for(int i = 0; i < size; i++){
            if(isPresent(row1, words[i]) || isPresent(row2, words[i]) || isPresent(row3, words[i])) list.add(words[i]);
        }
        String [] answerList = list.toArray(new String[list.size()]);
        return answerList;
    }
}