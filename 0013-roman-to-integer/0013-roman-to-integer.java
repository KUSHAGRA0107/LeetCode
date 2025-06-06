class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int answer = 0;
        int size = s.length();
        for(int i = 0; i < size; i++){
            if(i + 1 < size && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                answer += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i++;
            }else{
                answer += map.get(s.charAt(i));
            }
        }
        return answer;
        
    }
}