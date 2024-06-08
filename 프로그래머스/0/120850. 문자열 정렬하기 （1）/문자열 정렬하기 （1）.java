import java.util.*; 

class Solution {
    public int[] solution(String my_string) {
        int[] answer = null;
        List<Integer> list = new ArrayList<>();
        
        for(char c : my_string.toCharArray()){
            if(c >= '0' && c <= '9'){
                list.add(c-48); 
            }
        }
        
        Collections.sort(list); 
        System.out.println(list);
        
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i); 
        }
        
        return answer;
    }
}