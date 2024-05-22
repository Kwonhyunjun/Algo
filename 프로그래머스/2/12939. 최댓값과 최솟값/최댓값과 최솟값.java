import java.io.*;
import java.util.*;
    
class Solution {
    public String solution(String s) {
        String answer = "";
        
        List<Integer> list = new ArrayList<>(); 
        StringTokenizer st = new StringTokenizer(s);
        
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        int max = list.get(0); 
        int min = list.get(0);
        
        for(int cur : list){
            max = Math.max(max, cur); 
            min = Math.min(min, cur); 
        }
        
        answer = String.valueOf(min) + " " + String.valueOf(max); 
        
        return answer;
    }
}