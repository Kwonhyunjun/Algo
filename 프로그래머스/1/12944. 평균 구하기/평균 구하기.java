class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        for(int num : arr){
            answer += (double) num; 
        }
        
        answer /= arr.length;
        
        return answer;
    }
}