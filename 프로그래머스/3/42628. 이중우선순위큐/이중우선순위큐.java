import java.util.*;

class Solution {
    
    static class Data{
        int num; 
        boolean isDeleted; 
        
        public Data(int num){
            this.num = num;
            this.isDeleted = false;
        }
    }
    
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Data> min = new PriorityQueue<>((o1, o2) -> o1.num - o2.num);
        PriorityQueue<Data> max = new PriorityQueue<>((o1, o2) -> -(o1.num - o2.num));
        
        StringTokenizer st; 
        
        for(String oper : operations){
            st = new StringTokenizer(oper);
            
            char type = st.nextToken().charAt(0); 
            
            if(type == 'I'){
                Data cur = new Data(Integer.parseInt(st.nextToken()));
                
                min.offer(cur);
                max.offer(cur);
                
            }else{
                while(!min.isEmpty() && min.peek().isDeleted){
                    min.poll();
                }
                
                while(!max.isEmpty() && max.peek().isDeleted){
                    max.poll();
                }
                
                PriorityQueue<Data> cur = (Integer.parseInt(st.nextToken()) == 1) ? max : min;
                
                if(cur.isEmpty()) continue;
                
                Data removed = cur.poll();
                removed.isDeleted = true;
            }
        }
        
        while(!min.isEmpty() && min.peek().isDeleted){
            min.poll();
        }

        while(!max.isEmpty() && max.peek().isDeleted){
            max.poll();
        }
        
        int minest = (min.isEmpty()) ? 0 : min.poll().num;
        int maxest = (max.isEmpty()) ? 0 : max.poll().num;
        
        answer = new int[]{maxest, minest}; 
        
        return answer;
    }
}