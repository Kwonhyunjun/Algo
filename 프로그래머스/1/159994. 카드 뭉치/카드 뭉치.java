import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        Queue<String> c1 = new ArrayDeque<>();        
        Queue<String> c2 = new ArrayDeque<>();
        
        for(String str : cards1){
            c1.offer(str); 
        }
        
        for(String str : cards2){
            c2.offer(str); 
        }
        
        // while(!c1.isEmpty()){
        //     System.out.println(c1.poll());
        // }
        // while(!c2.isEmpty()){
        //     System.out.println(c2.poll());
        // }
        
        boolean canMake = true; 
        for(String str : goal){
            // System.out.println(str);
            if(!c1.isEmpty() && c1.peek().equals(str)){
                // System.out.println("1");
                c1.poll();
                continue;
            }
            
            if(!c2.isEmpty() && c2.peek().equals(str)){
                // System.out.println("2");
                c2.poll();
                continue;
            }
            
            // System.out.println("3");
            canMake = false;
            break; 
        }
        
        return canMake ? "Yes" : "No";
    }
}