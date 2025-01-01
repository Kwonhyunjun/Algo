import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        StringBuilder sb;
        ArrayList<Integer> list = new ArrayList<>();
        
        int cnt = 0; 
        int removeCnt = 0; 
        while(!s.equals("1")){
            int len = 0;
            for(char cur : s.toCharArray()){
                if(cur == '1') len++;
            }
            
            removeCnt += s.length() - len; 
            cnt++; 
            
            // System.out.println(Integer.toString(len, 2));
            s = Integer.toString(len, 2); 
        }
        
        answer = new int[]{cnt, removeCnt}; 
        return answer;
    }
}