class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> resultant;
        int index = 0;
        int size = intervals.size();
        
        /*Figuring Out Left Half*/

        while(index < size && intervals[index][1] < newInterval[0]){
            resultant.push_back({intervals[index][0], intervals[index][1]});
            index++;
        } 

        /*Figuring Out Overlapping Half*/
        while(index < size && intervals[index][0] <= newInterval[1]){
            newInterval[0] = min(newInterval[0], intervals[index][0]);
            newInterval[1] = max(newInterval[1], intervals[index][1]);
            index++;
        }
        resultant.push_back({newInterval[0], newInterval[1]});

        /*Figuring Right Half*/
        while(index < size){
            resultant.push_back({intervals[index][0], intervals[index][1]});
            index++;
        }

        return resultant;
    }
};