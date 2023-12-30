import java.util.*; 

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // 비동의 + 동의
        
        int len = choices.length; 
        HashMap<Character, Integer> m = new HashMap<>();
        
        for(int i=0; i<len; i++){
            if(choices[i] == 4) continue; 
            
            char c; 
            if(choices[i] < 4){ // 비동의쪽
                c = survey[i].charAt(0);
                
                int score = 4 - choices[i]; 
                
                if(m.containsKey(c)){
                    m.put(c, m.get(c) + score); 
                }else{
                    m.put(c, score);
                }
                
            }else{ // 동의 
                c = survey[i].charAt(1);
                
                 int score = choices[i] - 4; 
                
                if(m.containsKey(c)){
                    m.put(c, m.get(c) + score); 
                }else{
                    m.put(c, score);
                }
                
            }
        } // 점수 측정 완료
        
        char[] res = new char[4]; 
        
        // R, T
        int R = m.getOrDefault('R', 0); 
        int T = m.getOrDefault('T', 0); 
        
        if(R >= T){
            res[0] = 'R'; 
        }else{
            res[0] = 'T'; 
        }
        
        // F, C
        int F = m.getOrDefault('F', 0); 
        int C = m.getOrDefault('C', 0); 
        
        if(C >= F){
            res[1] = 'C'; 
        }else{
            res[1] = 'F'; 
        }
        
        // M, J
        int M = m.getOrDefault('M', 0); 
        int J = m.getOrDefault('J', 0); 
        
        if(J >= M){
            res[2] = 'J'; 
        }else{
            res[2] = 'M'; 
        }
        
        // A, N 
        int A = m.getOrDefault('A', 0); 
        int N = m.getOrDefault('N', 0); 
        
        if(A >= N){
            res[3] = 'A'; 
        }else{
            res[3] = 'N'; 
        }
        
        System.out.println(Arrays.toString(res)); 
        System.out.printf("R : %d T: %d F: %d C: %d M: %d J: %d A: %d N: %d  ", R, T, F, C, M, J, A, N);
        // Arrays.sort(res); 
        
        for(char ch : res){
            answer += ch;     
        }
        
        return answer;
    }
}