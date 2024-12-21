class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int len = nums.length; 
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                for(int k=j+1; k<len; k++){
                    if(check(nums[i] + nums[j] + nums[k])){
                        // System.out.printf("%d+%d+%d=%d\n", nums[i], nums[j], nums[k], nums[i] + nums[j] + nums[k]);
                        answer++;  
                    } 
                }
            }    
        }

        return answer;
    }
    
    static boolean check(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true; 
    }
}