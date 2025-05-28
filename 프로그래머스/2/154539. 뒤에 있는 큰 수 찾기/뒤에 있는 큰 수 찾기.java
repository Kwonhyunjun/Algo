import java.util.*; 

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack();
        
        answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        stack.add(numbers[numbers.length-1]);
        for(int i = numbers.length -2; i >= 0; i--){
            int cur = numbers[i];
            // System.out.println("cur : " + cur);
            // System.out.println(stack);
            // System.out.println(stack.peek());
            while(!stack.isEmpty() && cur >= stack.peek()){
                stack.pop();
            }
            // System.out.println(stack);
            if(!stack.isEmpty()) answer[i] = stack.peek();
            
            stack.add(cur);
        }
        
        return answer;
    }
}