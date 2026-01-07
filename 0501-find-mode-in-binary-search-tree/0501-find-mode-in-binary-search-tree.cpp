class Solution {
public:
    void inOrder(TreeNode* root, vector<int> &list){
        if(root == NULL) return;
        inOrder(root->left, list);
        list.push_back(root->val);
        inOrder(root->right, list);
    }
    vector<int> findMode(TreeNode* root) {
        unordered_map<int, int> map;
        vector<int> list;
        vector<int> answer;
        inOrder(root, list);
        int maxi = 0;
        for(int i = 0; i < list.size(); i++){
            map[list[i]] += 1;
            maxi = max(maxi, map[list[i]]);
        }   
        for(auto i : map){
            if(i.second == maxi){
                answer.push_back(i.first);
            }
        }
        return answer;
    }
};