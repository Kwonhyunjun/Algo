import java.io.*;
import java.util.*;

public class Main {

	static int N, M, compliments[];
	static class Node {
		int num;
		int parent;
		int compliment;
		List<Integer> child;
		
		public Node(int num, int parent) {
			this.num = num;
			this.parent = parent;
			this.compliment = 0;
			child = new ArrayList<>();
		}
	}
	
	static Node[] nodes;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodes = new Node[N+1];
		compliments = new int[N+1];
		Arrays.fill(compliments, -1);
		compliments[0] = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(i, parent);
			if(parent != -1) nodes[parent].child.add(i);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int j = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			nodes[j].compliment += w;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(solve(i)).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static int solve(int cur) {
		if(cur == -1) return 0;
		
		if(compliments[cur] != -1) return compliments[cur];
		
		return compliments[cur] = solve(nodes[cur].parent) + nodes[cur].compliment;
	}

}