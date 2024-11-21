import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String num = String.valueOf(n);
        Integer[] arr = new Integer[num.length()];

        // 각 자리수를 Integer 배열에 저장
        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i) - '0'; // '0'을 빼서 숫자로 변환
        }
        
        // System.out.println(Arrays.toString(arr));
        
 
        Arrays.sort(arr, (o1, o2) -> -(o1-o2));
        // System.out.println(Arrays.toString(arr));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            sb.append(arr[i]);
        }
        
        answer = Long.parseLong(sb.toString());
        
        return answer;
    }
}