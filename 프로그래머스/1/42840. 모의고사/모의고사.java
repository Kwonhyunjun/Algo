import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] arr2 = new int[]{1, 3, 4, 5};
        int[] arr3 = new int[]{3, 1, 2, 4, 5}; 
        
        int[] count = new int[3]; 
        
        int idx = 0;
        int idx2 = 0; 
        for(int i=0; i<answers.length; i++){
            int num1 = i%5+1;
            
            int num2 = 0;
            if(i%2 == 0){
                num2 = 2; 
            }else{
                num2 = arr2[idx%4]; 
                idx++; 
            }
             
            int num3 = arr3[idx2%5];
            if(i%2 != 0) idx2++;
            
            int cur = answers[i];
            if(cur == num1) count[0]++;
            if(cur == num2) count[1]++;
            if(cur == num3) count[2]++;
        }
        
        // System.out.println(Arrays.toString(count));
        
        int max = 0;
        for(int i=0; i<3; i++){
            max = Math.max(max, count[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(max == count[i]) list.add(i+1); 
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}