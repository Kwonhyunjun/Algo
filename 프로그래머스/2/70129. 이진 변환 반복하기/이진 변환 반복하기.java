class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int cnt = 0;  // 이진 변환의 횟수와 변환 과정
        int zero = 0; // 제거된 모든 0의 개수
        
        while(!s.equals("1")){
            
            int n = 0;
            for(char c : s.toCharArray()){
                if(c == '1') n++;
            }
            
            // System.out.println(s.length());
            // System.out.println(n); 
            
            zero += s.length() - n; 
            
            // System.out.println(zero); 
            
            s = binary(n);
            cnt++;
        }
        
        // System.out.println(binary(2));
        
        answer[0] = cnt; 
        answer[1] = zero;
        
        return answer;
    }
    
    public static String binary(int n){
        
        String res = ""; 
        
        while(n > 0){
            
            res = String.valueOf(n%2) + res; 
            n/=2;  
        }
        
        return res; 
    }
}