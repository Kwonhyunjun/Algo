import java.util.*; 

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[]{0, 0};
        StringTokenizer st; 
        
        TreeMap<Integer, Integer> map = new TreeMap<>(); 
        
        for(String s : operations){
            st = new StringTokenizer(s, " "); 
            int num = 0; 
            switch(st.nextToken()){
                case "I" :
                    num = Integer.parseInt(st.nextToken());
                    map.put(num, num); 
                    break; 
                case "D" :
                    if(map.isEmpty()) continue;
                    
                    if(st.nextToken().equals("1")){
                        int n1 = map.lastKey();
                        map.remove(n1); 
                        // System.out.printf("n1 : %d\n", n1);
                    }else{
                        int n2 = map.firstKey(); 
                        map.remove(n2);
                        // System.out.printf("n2 : %d\n", n2); 
                    }
                    break; 
            }
        }
        
        if(!map.isEmpty()){
            answer[0] = map.lastKey(); 
            answer[1] = map.firstKey(); 
        }
        
        
        return answer;
    }
}