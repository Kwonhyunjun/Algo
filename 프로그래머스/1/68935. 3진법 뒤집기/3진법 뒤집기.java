class Solution {
    public int solution(int n) {
        int answer = 0;
        System.out.println(toThree(n));
        
        int cnt = 0; 
        for(char c : toThree(n).toCharArray()){
            answer += (c-48) * (int) Math.pow(3, cnt);
            cnt++; 
        }
        
        return answer;
    }
    
    static String toThree(int n){
        StringBuilder sb = new StringBuilder(); 
        
        while(n > 0){
            sb.append(n%3);
            n /= 3; 
        }
        
        return sb.reverse().toString(); 
    }
}