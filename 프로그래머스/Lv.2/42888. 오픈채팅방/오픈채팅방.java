import java.util.*; 

class Solution {
    public String[] solution(String[] record) {
        StringTokenizer st; 
        
        List<String[]> log = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>(); 
        
        for(int i=0; i<record.length; i++){
            st = new StringTokenizer(record[i]);
            
            String type = st.nextToken(); 
            
            if(type.equals("Enter")){
                String id = st.nextToken(); 
                String name = st.nextToken();
                
                log.add(new String[]{id, "님이 들어왔습니다."});
                map.put(id, name); 
                
            }else if(type.equals("Change")){
                String id = st.nextToken(); 
                String name = st.nextToken();
                map.put(id, name); 
                
            }else{
                 String id = st.nextToken();
                log.add(new String[]{id, "님이 나갔습니다."});
            }
        }
        
        String[] answer = new String[log.size()]; 
        
        for(int i=0; i<log.size(); i++){
            String cur = map.get(log.get(i)[0]);
            // System.out.println(cur);
            
            answer[i] = cur + log.get(i)[1] ; 
        }
        
        return answer;
    }
}