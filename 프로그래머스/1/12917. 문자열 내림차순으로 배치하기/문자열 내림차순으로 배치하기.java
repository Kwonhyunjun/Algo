import java.util.*; 

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder(); 
        char[] c = s.toCharArray(); 
        
        Arrays.sort(c); 
        
        // System.out.println(Arrays.toString(c)); 
        
        for(int i = c.length-1; i>=0; i--){
            sb.append(c[i]);
        }
        
        return sb.toString();
    }
}