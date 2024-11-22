class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int num = x;
        int digitSum = 0;
        while(num > 0){
            digitSum += (num % 10);
            num /= 10; 
        }
        
        answer = (x % digitSum == 0) ? true : false;
        
        return answer;
    }
}