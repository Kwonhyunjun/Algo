import java.util.*; 

class Solution {
    /*
        4 3 1 2 5
    */
    public int solution(int[] order) {
        int answer = 0;
        
        int p = 0; // 실어야하는 택배 상자 번호 인덱스
        
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=1;;i++){
            int cur = order[p]; // 실어야 하는 택배 상자 번호
            // System.out.printf("%d번 택배 (%d번 실어야함) \n", i, cur);
            // System.out.printf("보조컨테이너 : %s\n", stack);
            
            if(cur < i && !stack.isEmpty() && stack.peek() != cur){
                // System.out.printf("이제 못뺌\n");
                break;  
            }
            
            // 상자 받기
            if(cur == i){
                // System.out.printf("바로 싣기\n");
                answer++;
                p++; 
                continue;
            }
            
            
            // 보조 컨테이너 확인
            while(!stack.isEmpty() && stack.peek() == cur){
                // System.out.printf("보조컨테이너 %d번 (%d번 실어야함) \n", stack.peek(), cur);
                stack.pop();
                answer++;
                p = (p+1 >= order.length) ? p : p+1;
                cur = order[p];
            }
            
            stack.add(i);
        }
        
        return answer;
    }
}