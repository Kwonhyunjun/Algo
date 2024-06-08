import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int len = people.length;
        boolean[] escaped = new boolean[len+1];
        
        Arrays.sort(people);
        // System.out.println(Arrays.toString(people)); 
        
        int left = 0; 
        int right = len-1; 
        int peoples = len;
        
        while(left <= right){
            
            if(people[left] + people[right] > limit){
                answer += 1; 
                right--;
            }else{
                answer += 1;
                left++; 
                right--;
            }
            
        }
        
        return answer;
    }
}