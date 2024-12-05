class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++){
            int cnt = count(i);
            answer = (cnt % 2 == 0) ? answer + i : answer - i; 
        }
        
        return answer;
    }
    
    static int count(int num){
        int cnt = 0;
        
        for(int i=1; i<=Math.sqrt(num); i++){
            // System.out.println(i);
            if(num % i == 0){
                if(num/i == i) {
                    cnt+= 1;    
                }else{
                    cnt+= 2;
                }
            } 
        }
        
        // System.out.println(num + " : " + cnt);
        return cnt; 
    }
}