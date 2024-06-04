import java.util.*;

class Solution {
    public long solution(long n) {
        // 자릿수를 저장할 배열 생성
        List<Integer> digits = new ArrayList<>();
        
        // 숫자를 추출하여 리스트에 저장
        while (n > 0) {
            digits.add((int) (n % 10));
            n /= 10;
        }
        
        // 리스트를 내림차순으로 정렬
        digits.sort(Comparator.reverseOrder());
        
        // 정렬된 리스트를 이용해 새로운 숫자 생성
        long answer = 0;
        for (int digit : digits) {
            answer = answer * 10 + digit;
        }
        
        return answer;
    }
}