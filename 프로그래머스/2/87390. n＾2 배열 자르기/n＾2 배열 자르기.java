import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(long i=left; i<=right; i++){
            int num = (int) i;
            int start = (int) ((i/n) + 1);
            int diff = (int) ((i%n) - start + 1);
            // System.out.printf("num : %d, start : %d, diff : %d\n", num, start, diff);
            if(diff > 0){
                start += diff; 
            }
            
            list.add(start);
        }
        
        // System.out.println(list);
        answer = list.stream().mapToInt(value -> value.intValue()).toArray();
        
        return answer;
    }
}