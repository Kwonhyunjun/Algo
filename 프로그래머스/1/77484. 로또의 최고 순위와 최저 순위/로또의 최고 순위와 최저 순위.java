import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        
        int[] score = new int[]{6, 6, 5, 4, 3, 2, 1};
        
        HashSet<Integer> set = new HashSet<>();
        for(int win_num : win_nums){
            set.add(win_num);
        }
        
        int correct = 0; 
        int ambiguous = 0;
        
        for(int lotto : lottos){
            if(lotto == 0){
                ambiguous++;
            }else{
                if(set.contains(lotto)){
                    correct++; 
                }
            }
        }
        
        answer = new int[]{score[correct+ambiguous], score[correct]};
        
        return answer;
    }
}