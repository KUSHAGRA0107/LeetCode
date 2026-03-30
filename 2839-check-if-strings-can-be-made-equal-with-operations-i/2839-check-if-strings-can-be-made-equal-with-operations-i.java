class Solution {
    public boolean canBeEqual(String s1, String s2) {
        /**Divide the array into two parts one for even and one for odd index */
        if(s1.length() != s2.length()) return false;
        int [] frequency = new int[256];
        Arrays.fill(frequency, 0);
        for(int i = 0; i < s1.length(); i++){
            /**if i & 1 is odd then it will give 128 means next partition else offset is 0 */
            int offset = (i & 1) << 7;
            frequency[offset + s1.charAt(i)]++;
            frequency[offset + s2.charAt(i)]--;
        }
        for(int i = 0; i < frequency.length; i++){
            if(frequency[i] != 0) return false;
        }return true;
    }
}