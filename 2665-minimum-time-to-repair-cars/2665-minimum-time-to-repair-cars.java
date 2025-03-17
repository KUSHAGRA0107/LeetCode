class Solution {
    public boolean isPossible(int [] ranks, int cars, long time){
        long carCount = 0;
        for(int i = 0; i < ranks.length; i++){
            carCount += (long)Math.sqrt(time/ranks[i]);
        }
        return carCount >= (long)cars;
    }
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        int max = Arrays.stream(ranks).min().getAsInt();
        long high = (long) max * cars * cars;
        long answer = 0;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(isPossible(ranks, cars, mid)){
                answer = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        } 
        return answer;
    }
}