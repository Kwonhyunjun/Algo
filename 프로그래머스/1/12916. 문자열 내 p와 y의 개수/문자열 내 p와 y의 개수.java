import java.util.*; 

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = new char[s.length()]; 
        
        arr = s.toCharArray(); 
        
        int cntp = 0; 
        int cnty = 0; 
        
        for(char c : arr){
            if(c == 'p' || c == 'P'){
                cntp++;
            }else if(c == 'y' || c == 'Y' ){
                cnty++; 
            }
        }

        answer = (cntp == cnty) ? true : false; 
        return answer;
    }
}