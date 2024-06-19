import java.util.*; 

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length; 
        int[] answer = new int[len];
        
        Stack<int[]> stack = new Stack<>(); 
        stack.push(new int[]{prices[0], 1}); 
        
        for(int i=1; i<len; i++){
            int t = i+1;
            int curPrice = prices[i];
            
            // System.out.printf("현재시각 : %d, 가격 : %d\n", t, curPrice);
            
            while(!stack.isEmpty() && stack.peek()[0] > curPrice){
                int[] down = stack.pop();
                // System.out.printf("내려간 가격 : %s\n", Arrays.toString(down));
                answer[down[1]-1] = t - down[1]; 
            }
            
            stack.push(new int[]{curPrice, t}); 
        }
        
        while(!stack.isEmpty()){
            int[] temp = stack.pop();
            // System.out.printf("남은 주식 : %s\n", Arrays.toString(temp));
            answer[temp[1]-1] = len - temp[1];
        }
        
        return answer;
    }
}