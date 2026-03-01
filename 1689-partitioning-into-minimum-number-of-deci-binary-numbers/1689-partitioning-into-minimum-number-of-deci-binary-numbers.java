class Solution {
    public int minPartitions(String n) {
        int maxi = -1;
        int size = n.length();
        for(int i = 0; i < size; i++){
            char ch = n.charAt(i);
            int value = Character.getNumericValue(ch);
            if(maxi < value) maxi = value;
        }
        return maxi;
    }
}