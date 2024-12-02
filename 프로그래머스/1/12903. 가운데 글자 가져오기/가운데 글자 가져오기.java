class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int middle = s.length() / 2;
        
        System.out.println(s.charAt(middle));
        
        if(s.length() % 2 == 0){
            sb.append(s.charAt(middle-1)).append(s.charAt(middle));
        }else{
            sb.append(s.charAt(middle));
        }
        
        return sb.toString();
    }
}