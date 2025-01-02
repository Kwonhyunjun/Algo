import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> q = new ArrayDeque<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			q.offer(i); 
		}
		
		sb.append("<");
		int idx = 0;
		while(!q.isEmpty()) {
			if(idx == K-1) {
				sb.append(q.poll()).append(", "); 
				idx = 0;
				continue;
			}
			
			q.offer(q.poll());
			idx++;
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb);

	}

}