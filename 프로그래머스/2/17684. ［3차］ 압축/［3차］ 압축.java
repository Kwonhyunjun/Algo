import java.util.*;

class Solution {
    
    static List<String> dict = new ArrayList<>(); 
    static List<Integer> indexes = new ArrayList<>(); 
    
    public int[] solution(String msg) {
//         int[] answer;
        
//         dict.add(""); 
        
//         for(int i=0; i<26; i++){
//             dict.add(String.valueOf((char)('A'+i)));
//         }
        
//         String sub = ""; 
//         for(int i=0; i<msg.length(); i++){
//              System.out.println("시작단어 : " + msg.charAt(i));
            
//             if(i == msg.length()-1){
//                 int index = dict.indexOf(String.valueOf((char)(msg.charAt(i)+1)));
//                 indexes.add(index);
//             }
            
//             for(int j=i+1; j<msg.length(); j++){
//                 // System.out.println(i + " " + j);
//                 sub = msg.substring(i, j+1); 
//                 // System.out.println(sub);
                
//                 if(!dict.contains(sub)){
//                     // System.out.println(sub); 
//                     // 색인번호 출력
//                     int index = dict.indexOf(sub.substring(0, sub.length()-1)); 
//                     indexes.add(index); 
                    
//                     // 사전등록
//                     dict.add(sub);
                    
//                     // System.out.println(dict.get(dict.size()-1) + " " + dict.size());
//                     i=j-1;
//                     break;
//                 }
//             }
//         }
        
//         System.out.println(sub);
        
//         return indexes.stream().mapToInt(Integer::intValue).toArray();
        
        // 사전 초기화
        dict.add(""); // 인덱스 0은 비워둠
        for(int i = 0; i < 26; i++) {
            dict.add(String.valueOf((char)('A' + i)));
        }
        
        for(int i = 0; i < msg.length(); i++) {
            String sub = String.valueOf(msg.charAt(i));
            
            for(int j = i + 1; j < msg.length(); j++) {
                if(!dict.contains(sub + msg.charAt(j))) {
                    break;
                }
                sub += msg.charAt(j);
                i = j; // i를 j로 업데이트하여 루프 종료 후 올바른 위치로 이동
            }
            
            int index = dict.indexOf(sub);
            indexes.add(index);
            
            if(i + 1 < msg.length()) {
                dict.add(sub + msg.charAt(i + 1));
            }
        }
        
        return indexes.stream().mapToInt(Integer::intValue).toArray();
    }
}