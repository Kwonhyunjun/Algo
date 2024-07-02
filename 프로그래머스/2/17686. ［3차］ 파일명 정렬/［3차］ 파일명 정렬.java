import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        PriorityQueue<File> pq = new PriorityQueue<>();
        
        for(int j=0; j<files.length; j++){
            String file = files[j];
            // System.out.printf("Original : %s -> ", file);
            
            // NUMBER 추출
            int headP = 0;
            for(int i=0; ;i++){
                if(file.charAt(i) >= 48 && file.charAt(i) <= 57){
                    headP = i;
                    break;
                }
            }
            String head = file.substring(0, headP).toLowerCase();
            // System.out.printf("%s/", head);
            
            // NUMBER 추출
            int numberP = -1;
            for(int i=headP; i<file.length(); i++){
                if(i >= (headP+5)){
                    numberP = i;
                    break;
                }
                
                if(file.charAt(i) < 48 || file.charAt(i) > 57){
                    numberP = i;
                    break;
                }
            }
            
            numberP = (numberP == -1) ? file.length() : numberP; 
            
            
            int number = Integer.parseInt(file.substring(headP, numberP).trim());
            // System.out.printf("%s/ \n", number);
            
            pq.add(new File(head, number, j, file));
            
        }
        
        answer = new String[pq.size()];
        int a = 0;
        while(!pq.isEmpty()){
            answer[a] = pq.poll().raw;
            a++;
        }
        return answer;
    }
    
    static class File implements Comparable<File>{
        String head;
        int number;
        int order;
        String raw;

        public File(String head, int number, int order, String raw){
            this.head = head;
            this.number = number;
            this.order = order;
            this.raw = raw;
        }

        @Override 
        public String toString(){
            return "HEAD : "+ this.head+" NUMBUER : "+ this.number+" Order : "+ this.order;
        }

        @Override
        public int compareTo(File o1){
            if(this.head.equals(o1.head)){
                if(this.number == o1.number){
                    return this.order - o1.order;    
                }
                return this.number - o1.number;
            }
            return this.head.compareTo(o1.head);

            // int len = (this.head.length() < o1.head.length()) ? this.head.length() : o1.head.length();
            // int p1 = 0; 
            // for(int i=0; i<len; i++){
            //     if(this.head.charAt(i) == o1.head.charAt(i)) continue;
            //     p1 = i; 
            // }
            // return this.head.charAt(p1) - o1.head.charAt(p1);
        }
    }
}