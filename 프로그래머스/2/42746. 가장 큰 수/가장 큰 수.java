import java.util.Arrays;
import java.util.Comparator;


class Solution {
    public static String solution(int[] numbers) {
	        String answer = "";
	        String[] nums = new String[numbers.length]; 
	        
	        for(int i=0; i<nums.length; i++) {
	        	nums[i] = numbers[i] +"";
//	        	nums[i] = Integer.toString(numbers[i]); 
	        }
	        
	        Arrays.sort(nums, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return -(Integer.parseInt(o1+o2)-Integer.parseInt(o2+o1));
				}
				
			});
	        
	        for(String a : nums) {
	        	answer += a;
	        }
        
            if(answer.charAt(0) == '0') {
	            answer = "0"; 
	        }
        
	        return answer;
	    }
}