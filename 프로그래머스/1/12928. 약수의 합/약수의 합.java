class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // System.out.println(Math.sqrt(n));
        
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                // System.out.println(i);
                answer += i;
                if(i != n/i) answer += n/i ;
            }
        }
        return answer;
    }
}