class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0,j = 0;
        int size = s.length();
        int maxi = 0;

        while(j < size){
            while(set.contains(s.charAt(j))){
                maxi = Math.max(maxi, j - i);
                set.remove(s.charAt(i));
                i++;
        }
            set.add(s.charAt(j));
            j++;                
        }
                maxi = Math.max(maxi, j - i);

        return maxi;
    }
}