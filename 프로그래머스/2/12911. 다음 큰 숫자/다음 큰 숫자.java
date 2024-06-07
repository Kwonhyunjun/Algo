class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // System.out.println(Integer.toString(n, 2));
        
        int target = 0; 
        for(char c : Integer.toString(n, 2).toCharArray()){
            if(c == '1') target++; 
        }
        
        // System.out.println(target); 
        
        while(true){
            n++; 
            
            String cur = Integer.toString(n, 2); 
            
            int cnt = 0; 
            for(char c : cur.toCharArray()){
                if(c == '1') cnt++; 
            }   
            
            if(cnt == target){
                answer = n; 
                break; 
            }
        
            
        }
        
        return answer;
    }
}