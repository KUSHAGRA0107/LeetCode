class Solution {
    public StringBuilder checkString(String str1, String str2, StringBuilder result){
        int size = (str1.length() > str2.length()) ? str2.length() : str1.length();
        for(int i = 0; i<size; i++){
            if(str1.charAt(i) != str2.charAt(i))break;
            result.append(str1.charAt(i));
        }
        return result;
    }
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder result = new StringBuilder();
        return checkString(strs[0], strs[strs.length - 1], result).toString();

    }
}