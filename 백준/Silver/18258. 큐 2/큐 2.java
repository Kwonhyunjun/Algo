import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder(); 
		
		int N = Integer.parseInt(br.readLine()); 
		Deque<Integer> q = new ArrayDeque<Integer>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push": 
				q.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop": 
				if(q.isEmpty()) {
					sb.append(-1+"\n"); 
				}else {
					sb.append(q.poll()+"\n");
				}
				break;
			case "size": 
				sb.append(q.size()+"\n");
				break;
			case "empty": 
				if(q.isEmpty()) {
					sb.append(1+"\n"); 
				}else {
					sb.append(0+"\n");
				}
				break;
			case "front": 
				if(q.isEmpty()) {
					sb.append(-1+"\n"); 
				}else {
					sb.append(q.peek()+"\n");
				}
				break;
			case "back": 
				if(q.isEmpty()) {
					sb.append(-1+"\n"); 
				}else {
					sb.append(q.peekLast()+"\n");
				}
				break;
			}
		}
		
		System.out.println(sb);
	}
}