class Solution {
    public long mostPoints(int[][] questions) {
        int size = questions.length;
        long [] table = new long[size];
        table[size - 1] = questions[size - 1][0];
        for(int i = size - 2; i >= 0; i--){
            long take = questions[i][0];
            if(i + questions[i][1] + 1 < size){
                take += table[i + questions[i][1] + 1];
            }
            long not_take = table[i + 1];
            table[i] = Math.max(take, not_take);
        }
        return table[0];
    }
}