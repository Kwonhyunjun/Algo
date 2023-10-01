import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		N = Integer.parseInt(br.readLine()); 
		
		Deque<Integer> q = new ArrayDeque<>(); 
		
		for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine());
			 
			 switch(st.nextToken()) {
			 case "push":
				 q.offer(Integer.parseInt(st.nextToken()));
				 break;
			 case "pop":
				 if(q.isEmpty()) {
					 System.out.println(-1);
				 }else {
					 System.out.println(q.poll());
				 }
				 break;
			 case "size":
				 System.out.println(q.size());
				 break;
			 case "empty":
				 if(q.isEmpty()) {
					 System.out.println(1);
				 }else {
					 System.out.println(0);
				 }
				 break;
			 case "front":
				 if(q.isEmpty()) {
					 System.out.println(-1);
				 }else {
					 System.out.println(q.peek());
				 }
				 break; 
			 case "back":
				 if(q.isEmpty()) {
					 System.out.println(-1);
				 }else {
					 System.out.println(q.peekLast());
				 }
				 break;  
			 }
		}
	}


}