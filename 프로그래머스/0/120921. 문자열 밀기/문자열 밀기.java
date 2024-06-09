class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        StringBuilder sb = new StringBuilder(); 
        
        if(A.equals(B)) return 0; 
        
        for(int i=0; i<A.length(); i++){
            // 문자열 밀기 
            // System.out.println("before " + A);
            // System.out.println(A.charAt(A.length()-1));
            // System.out.println(A.substring(0, A.length()-1));
            sb.append(A.charAt(A.length()-1)).append(A.substring(0, A.length()-1));
            A = sb.toString();
            // System.out.println("after " + A);
            if(A.equals(B)){
                answer = i+1; 
                break; 
            }
            sb.setLength(0);
        }
        
        return answer;
    }
}