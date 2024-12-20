import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] scores = new int[3];
        char[] arr = dartResult.toCharArray();
        
        int idx = 0; 
        
        System.out.println(arr.length);
        
        StringBuilder sb = new StringBuilder(); 
        for(int i=0; i<dartResult.length(); i++){
            char cur = arr[i];
            // System.out.println(i + " " + cur + " " + idx);
            
            if(cur == '*' || cur == '#'){
                if(cur == '*'){
                    for(int j=1; j<=2; j++){
                        if(idx-j < 0) continue; 
                        scores[idx-j] *= 2; 
                    }
                }else{
                    scores[idx-1] *= -1; 
                }
                continue;
            }
            
            if(cur == 'S' || cur == 'D' || cur == 'T'){
                int pow_num = (cur == 'S') ? 1 : (cur == 'D') ? 2 : 3; 
                
                int num = Integer.parseInt(sb.toString());
                scores[idx++] = (int) Math.pow(num, pow_num);
                sb.setLength(0);
                continue; 
            }
            
            sb.append(cur); 
        }
        
        // System.out.println(Arrays.toString(scores));
        
        for(int i=0; i<3; i++){
            answer += scores[i];
        }
        
        return answer;
    }
}