import java.util.*; 

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        // 문자열 정리 
        String[] arr = s.substring(1, s.length()-1).split("}");
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        for(String str : arr){
            str = str.replace("{", "").replace(",", " ").trim();
            // System.out.println(str); 
            String[] strArr = str.split(" "); 
            
            for(String s1 : strArr){
                int num = Integer.parseInt(s1); 
                map.put(num, map.getOrDefault(num, 0)+1); 
            }   
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet()); 
        
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        
        answer = new int[map.size()]; 
        
        int i = 0; 
        for(Map.Entry<Integer, Integer> a : entryList){
            // System.out.println(a.getKey() + " " + a.getValue()); 
            answer[i] = a.getKey(); 
            i++; 
        }
        
        
        
        return answer;
    }
}