class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        vector<int> answer;
        int carry = 1, value = 0;
        for(int i = digits.size() - 1; i >= 0; i--){
            value = digits[i] + carry;
            answer.push_back(value % 10);
            carry = value / 10;
        }
        if(carry != 0) answer.push_back(carry);
        reverse(answer.begin(), answer.end());
        return answer;
    }
};