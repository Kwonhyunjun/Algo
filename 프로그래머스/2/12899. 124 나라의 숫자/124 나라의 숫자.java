class Solution {
    public String solution(int n) {
        String answer = "";
        
        String[] nums = new String[]{"4", "1", "2"}; 
        StringBuilder sb = new StringBuilder(); 
        
        while(n > 0){
            sb.append(nums[n%3]); 
            
            if(n%3 == 0){
                n = n/3-1; 
            }else{
                n /= 3; 
            }
        }
        
        answer = sb.reverse().toString(); 
        
        return answer;
    }
}