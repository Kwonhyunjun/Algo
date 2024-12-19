class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        int[] monthly_day = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"}; 
        
        int total = 0;
        
        for(int i=0; i<a-1; i++){
            total += monthly_day[i];
        }
        
        total += b;
        total -= 1;
        
        answer = day[total%7];
        
        return answer;
    }
}