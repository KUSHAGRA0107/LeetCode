class Solution {
    public int minPartitions(String n) {
        /* Considering Each Digit as an Individual helps to solve the issue*/
        int maxi = -1;
        int size = n.length();
        for(int i = 0; i < size; i++){
            int value = Character.getNumericValue(n.charAt(i));
            maxi = value > maxi ? value : maxi;
        }
        return maxi;
    }
}