class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int divide = 1; 
        
        while(divide++ < n){
            if(n%divide == 1){
                answer = divide;
                break; 
            }
        }
        
        return answer;
    }
}