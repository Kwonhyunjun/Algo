import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int top = wallpaper.length;
        int left = wallpaper[0].length();
        int bottom = 0;
        int right = 0;
        
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                char cur = wallpaper[i].charAt(j);
                
                if(cur == '.') continue; 
                
                top = Math.min(top, i);
                left = Math.min(left, j);
                bottom = Math.max(bottom, i+1);
                right = Math.max(right, j+1);
            }
        }
        
        answer[0] = top;
        answer[1] = left;
        answer[2] = bottom;
        answer[3] = right;
        
        return answer;
    }
}