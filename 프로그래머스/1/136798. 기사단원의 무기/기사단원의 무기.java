class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++){
            int cnt = count(i);
            // System.out.println( i +  " " + cnt);
            answer += (cnt <= limit) ? cnt : power; 
        }
        
        return answer;
    }
    
    static int count(int num){
        // System.out.println("num : " + num);
        int res = 0;
        for(int i=1; i<Math.sqrt(num); i++){
            if(num % i == 0) res++;
        }
        
        res *= 2; 
        
        if(num % Math.sqrt(num) == 0) res += 1; 
        
        return res; 
    }
}