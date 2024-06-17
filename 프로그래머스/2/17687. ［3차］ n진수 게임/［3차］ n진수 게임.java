class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int len = t * m; // 찾아야하는 문자열 길이
        String str = ""; // 진행 문자열
        
        int num = 0; 
        while(str.length() < len){
            str += Integer.toString(num, n); 
            num++; 
        }
        
        str = str.toUpperCase(); 
        
        for(int i=0; i<t; i++){
            int start = i * m; 
            int end = start + m;  
            String substring = str.substring(start, end); 
            
            answer += substring.charAt(p-1); 
        }
        
        return answer;
    }
}