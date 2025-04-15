class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = nums2.length;
        for(int i = 0; i < size; i++){
            map.put(nums2[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        int [] temp = new int[size];
        Arrays.fill(temp, -1);
        stack.push(nums2[size - 1]);
        for(int i = size - 2; i >= 0; i--){
            while(!stack.empty() && stack.peek() <= nums2[i])stack.pop();
            if(!stack.empty()) temp[i] = stack.peek();
            stack.push(nums2[i]);
        }

        for(int i = 0; i < size; i++)System.out.println(temp[i]);
        size = nums1.length;
        int [] answer = new int[size];

        for(int i = 0; i < size; i++){
            int getIndex = map.get(nums1[i]);
            answer[i] = temp[getIndex];
        }
        return answer;
    }
}