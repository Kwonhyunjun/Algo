import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
		    @Override
		    public int compare(String o1, String o2) {
		        if(o1.length() == o2.length()) {
		        	return o1.compareTo(o2);
		        }
		        
		       return o1.length() - o2.length();
		    }
		});

		
		for(int i=0; i<N; i++) {
			String cur = br.readLine();
			
			if(pq.contains(cur)) continue;
			pq.offer(cur);
		}
		
		StringBuilder sb = new StringBuilder(); 
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(sb);

	}

}