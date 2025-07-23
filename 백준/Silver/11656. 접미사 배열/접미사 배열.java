import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		for(int i=0; i<str.length(); i++) {
			String cur = str.substring(i, str.length());
			
//			System.out.println(cur);
			
			pq.offer(cur);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(sb);

	}

}
