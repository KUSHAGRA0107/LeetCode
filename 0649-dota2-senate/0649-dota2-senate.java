class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> Radiant = new LinkedList<>();
        Queue<Integer> Dire = new LinkedList<>();
        int n = senate.length();

        for(int i = 0; i<n; i++){
            if(senate.charAt(i) == 'R'){
                Radiant.offer(i);
            }else{
                Dire.offer(i);
            }
        }

        while(!Radiant.isEmpty() && !Dire.isEmpty()){
            int radiant = Radiant.poll();
            int dire = Dire.poll();
            n++;
            if(radiant < dire){
                Radiant.offer(n);
            }else{
                Dire.offer(n);
            }
        }
        String answer = (!Radiant.isEmpty())? "Radiant" : "Dire";
        return answer;
    }
}