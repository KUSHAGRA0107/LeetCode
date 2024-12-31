class Solution {
    public static int getminCost(int index, HashSet<Integer> day, int [] cost,int [] dp, int [] days){
        if(index > days[days.length - 1]) return 0;
        if(dp[index] != -1) return dp[index];
        if(!day.contains(index)) return getminCost(index + 1, day, cost, dp, days);
        dp[index] = Math.min(
            Math.min(cost[1] + getminCost(index + 7, day, cost, dp, days), cost[2] + getminCost(index + 30, day, cost, dp, days)),
            cost[0] + getminCost(index + 1, day, cost, dp, days)
        );
        return dp[index];
    }
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < days.length; i++){
            set.add(days[i]);
        }
        int range = days[days.length - 1];
        int [] dp = new int[range + 1];
        for(int i = 0; i < range + 1; i++) dp[i] = -1;
        int answer = getminCost(0, set, costs, dp, days);
        return answer;
    
    }
}