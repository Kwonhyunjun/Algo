import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] arr = s.toCharArray();
        
        int cnt1 = 0;
        int cnt2 = 0;
        char x = 'a'; 
        
        for(char c : arr){
            // 첫 글자 저장
            if(cnt1 == 0) {
                x = c;
                cnt1++;
                continue;
            }
            
            // 글자 나온 횟수
            if(x == c){
                cnt1++; 
            }else{
                cnt2++;
            }
            
            // 두 횟수가 같아지는 순간
            if(cnt1 == cnt2){
                answer++;
                cnt1 = 0; 
                cnt2 = 0; 
            }
        }
        
        if(cnt1 != 0){
            answer++; 
        }
        
        return answer;
    }
}