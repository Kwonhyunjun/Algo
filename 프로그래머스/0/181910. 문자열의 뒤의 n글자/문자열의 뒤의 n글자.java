class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        int startIndex = my_string.length() - n; 
        answer = my_string.substring(startIndex); 
        
        return answer;
    }
}