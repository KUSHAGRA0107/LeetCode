class Solution {
    public boolean canChange(String start, String target) {
        int startLength = start.length();
        int targetLength = target.length();
        int startIndex = 0;
        int targetIndex = 0;

        while(targetIndex < targetLength || startIndex < startLength){
            while(startIndex < startLength && start.charAt(startIndex) == '_'){
                startIndex++;
            }
            while(targetIndex < targetLength && target.charAt(targetIndex) == '_'){
                targetIndex++;
            }
            if(startIndex == startLength || targetIndex == targetLength){
                return (startIndex == startLength && targetIndex == targetLength);
            }
            if(start.charAt(startIndex) != target.charAt(targetIndex) || 
            (start.charAt(startIndex) == 'L' && startIndex < targetIndex) ||
            (start.charAt(startIndex) == 'R' && startIndex > targetIndex)){
                return false;
            }
            startIndex++;
            targetIndex++;
        }     
        return true;
    }
}