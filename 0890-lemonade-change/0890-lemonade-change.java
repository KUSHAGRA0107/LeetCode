class Solution {
    public boolean lemonadeChange(int[] bills) {
        int size = bills.length;
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for(int i = 0; i < size; i++){
            if(bills[i] == 5){
                five++;
            }else if(bills[i] == 10){
                five--;
                ten++;
                if(five < 0) return false;
            }else{
                if(ten >= 1 && five >= 1){
                    five--;
                    ten--;
                }
                else if(five >= 3){
                    five -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}