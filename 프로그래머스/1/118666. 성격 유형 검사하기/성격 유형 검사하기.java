import java.util.*;

class Solution {
    class Data{
        char type; 
        int score;
        public Data(char type, int score){
            this.type = type;
            this.score = score;
        }
    }
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        char[] type = new char[]{'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'}; 
        Data[][] result = new Data[4][2];
        HashMap<Character, int[]> map = new HashMap<>();
        for(int i=0; i<8; i++){
            map.put(type[i], new int[]{i/2, i%2});
            result[i/2][i%2] = new Data(type[i], 0);
        }
        
        int len = survey.length;
        
        for(int i=0; i<len; i++){
            String types = survey[i];
            int score = choices[i];
            
            if(score == 4) continue; 
            
            char typeIdx = (score > 4) ? types.charAt(1) : types.charAt(0); 
            int weight = Math.abs(score - 4); 
            
            int[] matrixIdx = map.get(typeIdx);
            result[matrixIdx[0]][matrixIdx[1]].score += weight;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++){
            Data first = result[i][0];
            Data second = result[i][1];
            char select = (first.score >= second.score) ? first.type : second.type;
            sb.append(select);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}