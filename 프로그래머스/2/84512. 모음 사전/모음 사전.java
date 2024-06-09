import java.util.*; 

class Solution {
    
    static int num = 0, answer=0;
    static String[] str;
    static StringBuilder sb = new StringBuilder();
    static String target; 
    static boolean flag =false;
    
    public int solution(String word) {
        str = new String[5]; 
        target = word; 
        
        perm(0);
        
        return answer;
    }
    
    public static void perm(int cnt){
        // System.out.println(Arrays.toString(str) + " "+ num);
        if(flag){
            return;  
        } 
        
        if(target.length() == cnt){
            String cur = ""; 
            for(int i=0; i<target.length(); i++){
                if(str[i] == null)continue; 
                cur += str[i]; 
            }
            
            if(cur.equals(target)){
                flag = true; 
                System.out.println(num);
                answer = num;
                return;
            }
        }
        
        if(cnt == 5){
            return; 
        }
        
        // A 넣고 다음 으로 넘기고
        str[cnt] = "A"; 
        num++;
        perm(cnt+1); 
        
        
        
        // E 넣고 다음
        str[cnt] = "E"; 
        num++;
        perm(cnt+1);  
        
        // I
        str[cnt] = "I"; 
        num++;
        perm(cnt+1); 
        
        // O
        str[cnt] = "O"; 
        num++;
        perm(cnt+1); 
        
        // U
        str[cnt] = "U"; 
        num++; 
        perm(cnt+1); 
        
        return; 
    }
}