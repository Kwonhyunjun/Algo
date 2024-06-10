// import java.util.*; 

// class Solution {
//     public int solution(int m, int n, String[] board) {
//         int answer = 0;
        
//         int r = board.length; 
//         int c = board[0].length(); 
        
//         List[] map = new List[c];
        
//         for(int i=0; i<c; i++){
//             map[i] = new ArrayList<Character>(); 
//         }
        
//         for(int i=0; i<c; i++){
//             for(int j=r-1; j>=0; j--){
//                 char cur = board[j].charAt(i); 
//                 // System.out.print(cur);
//                 map[i].add(cur); 
//             }
//             // System.out.println(); 
//         }
        
//         // for(List<Character> list : map){
//         //     System.out.println(list);
//         // }
        
        
        
        
//         while(true){
//             // 삭제 대상 탐색
//             TreeSet<String> set = new TreeSet<>(); 

//             for(int i=0; i<c; i++){
//                 for(int j=0; j<map[i].size(); j++){
//                     if( (i+1) >= c || (j+1) >= map[i].size()) continue;

//                     boolean flag = true; 
//                     char cur = (char) map[i].get(j); 

//                     // 네모 탐색
//                     for(int k=0; k<2; k++){
//                         for(int l=0; l<2; l++){
//                             if(cur != (char) map[i+k].get(j+l))
//                                 flag = false;
//                         }
//                     }

//                     // 삭제블록 마킹 
//                     if(flag){
//                         for(int k=0; k<2; k++){
//                             for(int l=0; l<2; l++){
//                                 set.add(""+(i+k) + (j+l)); 
//                             }
//                         }
//                     }
//                 }
//             }
            
//             // 삭제할게 없으면 멈춤
//             if(set.isEmpty()) break;
            
//             for(String str : set){
//                 int a = str.charAt(0) - '0'; 
//                 int b = str.charAt(1) - '0'; 
//                 System.out.println(a + " " + b); 
//                 // map[a].remove(b); 
//             }
            
//             System.out.println(set.size());
//             answer += set.size(); 
//             set.clear(); 
//             break;
//         }
        
        
        
//         return answer;
//     }
// }

import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        int r = board.length; 
        int c = board[0].length(); 
        
        List<Character>[] map = new List[c];
        
        for(int i = 0; i < c; i++){
            map[i] = new ArrayList<Character>(); 
        }
        
        for(int i = 0; i < c; i++){
            for(int j = r - 1; j >= 0; j--){
                char cur = board[j].charAt(i); 
                map[i].add(cur); 
            }
        }
        
        while (true) {
            // 삭제 대상 탐색
            boolean[][] toRemove = new boolean[c][r];
            boolean hasBlockToRemove = false;

            for (int i = 0; i < c - 1; i++) {
                for (int j = 0; j < map[i].size() - 1; j++) {
                    if (j + 1 >= map[i + 1].size()) continue;
                    
                    char cur = map[i].get(j);
                    if (cur != map[i].get(j + 1)) continue;
                    if (cur != map[i + 1].get(j)) continue;
                    if (cur != map[i + 1].get(j + 1)) continue;
                    
                    toRemove[i][j] = true;
                    toRemove[i][j + 1] = true;
                    toRemove[i + 1][j] = true;
                    toRemove[i + 1][j + 1] = true;
                    hasBlockToRemove = true;
                }
            }
            
            // 삭제할 블록이 없으면 루프 종료
            if (!hasBlockToRemove) break;
            
            // 삭제할 블록 수 세기
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < map[i].size(); j++) {
                    if (toRemove[i][j]) {
                        answer++;
                    }
                }
            }

            // 블록 제거
            for (int i = 0; i < c; i++) {
                for (int j = map[i].size() - 1; j >= 0; j--) {
                    if (toRemove[i][j]) {
                        map[i].remove(j);
                    }
                }
            }
        }
        
        return answer;
    }
}
