class Solution {
    public List<List<String>> groupAnagrams(String [] strs) {
        List<List<String>> result = new ArrayList<>();
        int size = strs.length;
        HashMap<String, List<String>> anagrams = new HashMap<>();
        /*
        1. Iterate over String[]
        2. First of all sort the current string, and check
        of their exist any key in the hashMap of the current type
            a. if match --> hashmap.get(key).add(strs[i]);
            b. else hashmap.put(key, new List(strs[i]))
        3. finally iterate over hashMap and add values to your final list
        */
        for(int i = 0; i < size; i++){
            String currentString = strs[i];
            /*Sorting A string eat --> ['e', 'a', 't']*/
            char [] currArr = currentString.toCharArray();
            Arrays.sort(currArr);
            String Key = new String(currArr);
            if(anagrams.containsKey(Key)){
                /*Get that list from the key and add your strs[i] */
                List<String> keyList = anagrams.get(Key); /*[eat, tea] */
                keyList.add(currentString); /*[eat, tea, ate] because shallow copy */
            }else{
                List<String> newKeyList = new ArrayList<>(); /*[] */
                newKeyList.add(currentString); /*[tan]*/
                anagrams.put(Key, newKeyList); /*ant --> [tan] */
            }
        }

        for(String key : anagrams.keySet()){
            List<String> list = anagrams.get(key);
            result.add(list);
        }
        return result;
    }
}