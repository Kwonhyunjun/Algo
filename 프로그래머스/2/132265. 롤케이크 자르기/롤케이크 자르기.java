import java.util.*; 

class Solution {
    /*
        topping : 롤케이크에 올려진 토핑들의 번호
        
        return 롤케이크를 공평하게 자르는 방법의 수
    */
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length; 
        
        HashSet<Integer> set = new HashSet<>(); 
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            map.put(topping[i], map.getOrDefault(topping[i], 0)+1); 
        }
        
        int left = set.size(); 
        int right = map.size();
        
        // System.out.printf("left : %d , right : %d\n", left, right); 
        
        for(int i=0; i<len; i++){
            int cur = topping[i]; 
            
            // 오른쪽 처리
            map.put(cur, map.get(cur)-1); 
            if(map.get(cur) == 0) right--; 
            
            // 왼쪽 처리
            if(set.add(cur)) left++; 
            
            if(right == left) answer++;
        }
        
        
        return answer;
    }
}