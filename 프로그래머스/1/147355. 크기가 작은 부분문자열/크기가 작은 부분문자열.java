class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        long p_num = Long.parseLong(p);
        
        for(int i=0; i<=t.length() - p.length(); i++){
            String part = t.substring(i, i+p.length()); 
            
            if(p_num >= Long.parseLong(part)) answer++;
                    
        }
        
        return answer;
    }
}