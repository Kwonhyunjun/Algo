import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1-o2));
		for(char c : str.toCharArray()) {
			pq.offer(c - '0'); 
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll());
		}
		
		System.out.println(sb);

	}

}