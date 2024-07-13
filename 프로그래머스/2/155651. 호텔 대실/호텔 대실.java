import java.util.*; 

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>(){
            @Override
            public int compare(Data o1, Data o2){
                return o1.start_time - o2.start_time; 
            }
        });
        
        for(int i=0; i<book_time.length; i++){ 
            String s = book_time[i][0];
            String e = book_time[i][1]; 
            
            int st = Integer.parseInt(s.substring(0, 2) + s.substring(3, 5));
            int et = Integer.parseInt(e.substring(0, 2) + e.substring(3, 5));
            // 1358 -> 1368 -> 1408
            if((et + 10) % 100 > 60){
                et = et + 50; 
            }else{
                et += 10; 
            }
            pq.add(new Data(s, st, e, et, i));
        }
        
        List<Data> rooms = new ArrayList<>(); 
        rooms.add(pq.poll());
        
        while(!pq.isEmpty()){
            Data cur = pq.poll();
            
            for(int i=0; i<rooms.size(); i++){
                // System.out.printf("%d 번방 마감 시간 %d \n", i, rooms.get(i).end_time); 
            }
            
            // System.out.printf("Data : %d ~ %d\n", cur.start_time, cur.end_time);
            
            int gap = 2400; 
            int idx = -1; 
            
            for(int i=0; i<rooms.size(); i++){
                Data d = rooms.get(i); 
                if(cur.start_time < d.end_time) continue;
                if(Math.abs(cur.start_time - d.end_time) < gap){
                    gap = cur.start_time - d.end_time; 
                    idx = i; 
                } 
            }
            
            if(idx == -1){
                // System.out.println("맞는방없음\n");
                rooms.add(cur);
            }else{
                // System.out.printf("%d 추가\n", idx);
                rooms.set(idx, cur);    
            }
        }
        
        answer = rooms.size();
        
        return answer;
    }
    
    static class Data{
        String start;
        String end; 
        int start_time;
        int end_time;
        int order; 
        
        public Data(String start, int start_time, String end, int end_time, int order){
            this.start = start; 
            this.end = end;
            this.order = order;
            this.start_time = start_time;
            this.end_time = end_time; 
        }
    }
}