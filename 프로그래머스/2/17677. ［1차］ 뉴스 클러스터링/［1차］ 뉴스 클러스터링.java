import java.util.*; 

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List li1 = make(str1);
        List li2 = make(str2);
        
        // System.out.println(li1); 
        // System.out.println(li2);
        
        if(li1.size() == 0 && li2.size() == 0){
            return 65536; 
        }
        
        int cnt = 0; 
        
        for(int i =0 ; i< li1.size(); i++){
            
            int size = li2.size(); 
            
            for(int j = 0; j < li2.size(); j++){
                if(li1.get(i).equals(li2.get(j))){
                    cnt++; 
                    li2.remove(j); 
                    break; 
                }
            }
        }
        
        int parent = li1.size() + li2.size(); 
        
        // System.out.println(cnt); 
        // System.out.println(parent); 
        
        float res = (float) cnt / (float) parent;
        
        answer = (int) (res * 65536); 
        
        
        return answer;
    }
    
    static List<String> make(String str){ 
        List<String> list = new ArrayList<>(); 
        
        int len1 = str.length(); 
        
        for(int i=0; i<len1; i++){
            if(i+1 >= len1) break; 
            
            String sub = str.substring(i, i+2).toUpperCase(); 
            // System.out.println(sub); 
            // 특수문자, 숫자 포함되어 있으면 버림
            char c1 = sub.charAt(0);
            char c2 = sub.charAt(1);
            
            // System.out.println((int) c1 +" "+ (int) c2); 
            // System.out.println((int) 'Z'); 
            
            if((int) c1 < 65 || c1 > 90 ) continue;
            if((int) c2 < 65 || c2 > 90 ) continue;
            
            list.add(sub); 
        }
        
        
        
        return list; 
    }
    
}