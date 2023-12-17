import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> result = new HashSet<>();

        // 부분 수열의 원소 개수
        for(int i = 1; i <= elements.length; i++){
            int val = 0;
            // init
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j<i; j++) val += elements[j% elements.length];
            set.add(val);

            // linear calculate
            for(int j = 0; j < elements.length; j++){
                val -= elements[j% elements.length];
                val += elements[(j + i) % elements.length];
                set.add(val);
            }
            result.addAll(set);
        }
        return result.size();
    }
}