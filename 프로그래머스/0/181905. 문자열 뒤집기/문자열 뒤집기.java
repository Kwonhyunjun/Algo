class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        StringBuilder sb = new StringBuilder(); 
        
        
        String subString = my_string.substring(s, e+1); 
        System.out.println(subString); 
        
        sb.append(subString);
         
        subString = sb.reverse().toString();
        
        sb.setLength(0); 
        
        sb.append(my_string.substring(0, s)).append(subString).append(my_string.substring(e+1));
        
        
        
        return sb.toString();
    }
}