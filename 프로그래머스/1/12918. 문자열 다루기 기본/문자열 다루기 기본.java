class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        int len = s.length(); 
        
        if(!(len == 4 || len == 6)) return false;
        
        for(char c : s.toCharArray()){
            int cur = c - 0; 
            
            if(cur < 48 || cur > 57) return false;
        }
        
        return answer;
    }
}