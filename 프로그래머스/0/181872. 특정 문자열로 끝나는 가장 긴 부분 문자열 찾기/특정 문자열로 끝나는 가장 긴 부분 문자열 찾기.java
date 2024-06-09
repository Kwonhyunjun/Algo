class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        
        int index = myString.lastIndexOf(pat);
        
        System.out.println(index); 
        
        int end = index + pat.length(); 
        
        answer = myString.substring(0, end); 
        
        return answer;
    }
}