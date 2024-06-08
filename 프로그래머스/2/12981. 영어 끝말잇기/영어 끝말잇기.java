import java.util.*; 

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> past = new ArrayList<>();
        int curCnt = 0;
        int humanNum = 0;
        
        char lastWord = words[0].charAt(words[0].length() -1);
        past.add(words[0]); 
        
        for(int i = 1; i<words.length; i++){
            humanNum = (i % n) + 1; 
            if(past.contains(words[i]) || words[i].charAt(0) != lastWord){
                curCnt = i+1;
                break; 
            }
               
            lastWord = words[i].charAt(words[i].length() -1);
            past.add(words[i]); 
        }

        System.out.println(curCnt);

        answer[0] = (curCnt == 0)? 0 :humanNum;  // 가장 먼저 탈락하는 사람의 번호
        answer[1] = (curCnt + n - 1) / n;

        return answer;
    }
}