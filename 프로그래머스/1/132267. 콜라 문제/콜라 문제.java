class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int bottle = n; 
        
        while(bottle >= a){
            int re = (bottle / a) * b;
            bottle %= a; 
            bottle += re; 
            answer += re; 
        }
        return answer;
    }
}