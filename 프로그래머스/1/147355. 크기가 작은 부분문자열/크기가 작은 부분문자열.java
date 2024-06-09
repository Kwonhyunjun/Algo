class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int cnt = t.length() - p.length();
        long num = Long.parseLong(p); 
        
        for(int i=0; i<cnt+1 ; i++){
            String str = t.substring(i, i+p.length()); 
            // System.out.println(Integer.parseInt(str)); 
            
            if(num >= Long.parseLong(str)){
                answer++; 
            }
        }
        return answer;
    }
}