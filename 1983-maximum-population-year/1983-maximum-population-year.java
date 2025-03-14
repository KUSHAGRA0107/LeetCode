class Solution {
    public int maximumPopulation(int[][] logs) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int log = 0; log < logs.length; log++){
            int start_year = logs[log][0];
            int end_year = logs[log][1];
            for(int year = start_year; year < end_year; year++){
                map.put(year , map.getOrDefault(year, 0) + 1);
            }
        }
        int max_value = 0, answer_year = 2051;
        for(Integer key : map.keySet()){
            if(map.get(key) > max_value || (map.get(key) == max_value && key < answer_year))
                {
                max_value = map.get(key);
                answer_year = key;
            }
        }
        return answer_year;
    }
}