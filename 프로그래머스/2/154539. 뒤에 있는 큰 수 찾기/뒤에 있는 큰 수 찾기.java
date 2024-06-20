import java.util.*; 

class Solution {
    /*
        뒷 큰수 : 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수
    */
    public int[] solution(int[] numbers) {
        int len = numbers.length; 
        int[] answer = new int[len];
        
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        
        int max = numbers[len-1]; 
        stack.push(numbers[len-1]); 
        answer[len-1] = -1; 
        
        for(int i=len-2; i>=0; i--){
            int cur = numbers[i];
            // System.out.printf("cur : %d\n",cur); 
            
            if(cur >= max){
                // System.out.printf("현재값이 최대값\n",cur); 
                answer[i] = -1; 
                max = cur; 
                stack.push(cur);
                continue;
            }
            
            if(numbers[i] >= numbers[i+1] && numbers[i] < answer[i+1]){
                // System.out.printf("%d\n", i); 
                answer[i] = answer[i+1]; 
                stack.push(cur); 
                continue; 
            }
            
            
            while(stack.peek() <= cur){ 
                // System.out.printf("대소비교 stack.peek() : %d vs cur : %d\n",stack.peek(), cur); 
                
                temp.push(stack.pop());
            }
            
            // System.out.printf("최대값 찾은 후 : %d\n",stack.peek()); 
            answer[i] = stack.peek(); 
            
            while(!temp.isEmpty()){
                if(cur >= temp.pop()) continue;
                stack.push(temp.pop()); 
            }
            
            stack.push(cur); 
            
        }
        
        return answer;
    }
}