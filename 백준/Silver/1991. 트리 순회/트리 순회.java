import java.io.*;
import java.util.*; 

public class Main {
	
	static HashMap<String, Node> map = new HashMap<>(); 
	
	static class Node{
		String data; 
		Node left, right;
		
		public Node(String data) {
			this.data = data; 
			left = null;
			right = null; 
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			String parent = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			if(!map.containsKey(parent)) {
				map.put(parent, new Node(parent)); 
			}
			
			if(!map.containsKey(left)) {
				map.put(left, new Node(left)); 
			}
			
			if(!map.containsKey(right)) {
				map.put(right, new Node(right)); 
			}
			
			Node p = map.get(parent);
			p.left = map.get(left);
			p.right = map.get(right); 
		}
		
		Node parent = map.get("A");
		
		pre(parent); 
		sb.append("\n");
		mid(parent);
		sb.append("\n");
		post(parent);
		
		System.out.println(sb);
	}
	
	static StringBuilder sb = new StringBuilder(); 
	
	static void pre(Node cur) {
		if(cur == null || cur.data.equals(".")) {
			return; 
		}
		
		sb.append(cur.data);
		pre(cur.left);
		pre(cur.right);
		
	}
	
	static void mid(Node cur) {
		if(cur == null || cur.data.equals(".")) {
			return; 
		}
		
		mid(cur.left);
		sb.append(cur.data);
		mid(cur.right);
		
	}
	
	static void post(Node cur) {
		if(cur == null || cur.data.equals(".")) {
			return; 
		}
		
		post(cur.left);
		post(cur.right);
		sb.append(cur.data);
		
	}
	
}