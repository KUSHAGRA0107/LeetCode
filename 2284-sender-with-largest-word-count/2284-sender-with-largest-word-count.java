class Solution {
    public int countWord(String sentence){
        int count = 0;
        boolean isWord = false;
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) != ' ' && !isWord){
                isWord = true;
                count++;
            }else if(sentence.charAt(i) == ' '){
                isWord = false;
            }
        }
        return count;
    }
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        int maxi = 0;
        for(int i = 0;i < senders.length; i++){
            map.put(senders[i], 0);
        }

        for(int i = 0; i < messages.length; i++){
            map.put(senders[i],map.get(senders[i]) + countWord(messages[i]));
        }

        for(String key : map.keySet()){
            if(map.get(key) > maxi){
                maxi = map.get(key);
                answer = key;
            }else if(map.get(key) == maxi){
                int temp = answer.compareTo(key);
                if(temp < 0){
                    answer = key; 
                }
            }
        }
        return answer;
    }
}