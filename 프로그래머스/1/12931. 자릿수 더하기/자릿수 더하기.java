import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while(n > 0){
            int digit = n % 10; 
            n /= 10; 
            // System.out.println(digit);
            answer += digit;
        }

        return answer;
    }
}