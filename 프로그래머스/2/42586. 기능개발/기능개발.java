
// 개발속도는 다름 -> 뒤에 있는 기능이 다 끝나면 앞에 있는 기능이 완료 시 함께 배포

/* input

int[] progresses :  작업의 진도(먼저 배포되어야 하는 순서)
int[] speeds[]  : 개발 속도

*/

/* output
각 배포 마다 몇 개의 기능이 배포되는지 return; 
*/ 

import java.util.*; 

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> deployCnt = new ArrayList<>();
        Queue<int[]> waiting = new ArrayDeque<>(); 
        
        // 초기화
        for(int i=0; i<progresses.length ; i++){
            waiting.offer(new int[]{i, progresses[i]}); 
        }
        
        while(!waiting.isEmpty()){
            
            // 진행
            int size = waiting.size(); 
            
            for(int i=0; i<size; i++){
                int[] cur = waiting.poll();
                waiting.offer(new int[]{cur[0], cur[1]+speeds[cur[0]]}); 
            }
            
            // for(int[] arr : waiting){
            //     System.out.print(Arrays.toString(arr)+ " ");
            // }
            // System.out.println();
            
            int cnt = 0; 
            while(waiting.peek()[1] >= 100){
                waiting.poll(); 
                cnt++; 
                
                if(waiting.isEmpty()){
                    break;
                }
            }
            if(cnt > 0) deployCnt.add(cnt); 
        }
        
        // System.out.println(deployCnt); 
        
        answer = deployCnt.stream().mapToInt(Integer::intValue).toArray(); 
        
        return answer;
    }
}