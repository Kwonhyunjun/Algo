import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static Node[] adjList;
	static boolean[] v;
	static int ans;
	static boolean flag;

	static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
		
		

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new Node[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()); 
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]); 
			adjList[to] = new Node(from, adjList[to]); 
			
		}
		
//		for(Node n : adjList) {
//			System.out.println(n);
//		}
		
		// Input End 
		flag = false;
		for(int i=0; i<N;i++) {
			v = new boolean[N]; 
			if(adjList[i] == null) continue; // 연결되어있지 않으면 continue; 
			v[i] = true;
			dfs(i ,1);
			v[i] = false;
			
			if(flag) break;
		}
		
		System.out.println(ans);
		
	}

	static void dfs(int start, int depth) {
		if(depth == 5) { 
			ans = 1;  
			flag = true;
			return; 
		}
		
		
		for(Node temp  = adjList[start] ; temp != null ; temp = temp.next) {
			if(!v[temp.data]) {
				v[temp.data] = true; 
				dfs(temp.data, depth+1);	
				if(flag) return;
				v[temp.data] = false;
				
			}
		}
	}
}
