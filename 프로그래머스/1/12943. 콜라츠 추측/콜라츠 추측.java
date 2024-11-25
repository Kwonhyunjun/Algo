class Solution {
    public int solution(int num) {
        int answer = 0;
        
        long n = num; 
        
        for(int i=0; i<500; i++){
            
            if(n == 1){
                answer = i;
                break;
            }
            
            if(n % 2 == 0){
                n /= 2;
            }else{
                n = n * 3 + 1;
            }
            
            
        }
        
        if(n != 1) answer = -1;
        
        return answer;
    }
}