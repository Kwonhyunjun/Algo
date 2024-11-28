class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder(phone_number);
        
        int num = phone_number.length() - 4;
        String str = "*".repeat(num); 
        
        sb.replace(0, num, str);
        
        answer = sb.toString();
        
        return answer;
    }
}