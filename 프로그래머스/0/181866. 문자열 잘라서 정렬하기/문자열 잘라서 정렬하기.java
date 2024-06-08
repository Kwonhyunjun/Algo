import java.util.*; 

class Solution {
    public String[] solution(String myString) {
        String[] answer = {};
        
        List<String> list = new ArrayList<>(); 
        String str = ""; 
        
        for(int i=0; i<myString.length(); i++){
        
            char cur = myString.charAt(i); 
            
            if(cur == 'x'){
                if(str.equals("")) continue; 
                
                list.add(str);
                str = "";
                continue; 
            }

            
            str += cur;
        }
        
        // System.out.println(str);

        if(!str.equals("")){
            list.add(str); 
        }
        
        String[] arr = new String[list.size()]; 
        
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        
        Arrays.sort(arr);
        
        // System.out.println(list);
        
        return arr;
    }
}