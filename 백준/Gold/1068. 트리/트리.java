import java.io.*;
import java.util.*;

public class Main {
	
	static int N, removeNode, root, answer;
	static Node[] tree; 
	
	static class Node{
		int num;
		boolean isActive;
		ArrayList<Integer> childs = new ArrayList<>(); 
		
		public Node(int num) {
			this.num = num; 
			this.isActive = true; 
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine()); 
		
		tree = new Node[N]; 

		// 트리 초기화
		for(int i=0; i<N; i++) {
			tree[i] = new Node(i); 
		}
		
		st = new StringTokenizer(br.readLine()); 
		
		
		for(int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			
			if(parent == -1) {
				root = i;
				continue; 
			}
			
			tree[parent].childs.add(i); 
			
		}
		removeNode = Integer.parseInt(br.readLine());
		tree[removeNode].isActive = false;
		
		dfs(root); 
		
		System.out.println(answer);
		
		 
	}
	
	static void dfs(int idx) {
		Node curNode = tree[idx];
		if(!curNode.isActive) return; 
//		System.out.println(curNode.num);
		
		if(curNode.childs.isEmpty()) {
			answer++; 
			return;
		}
		
		boolean flag = true; 
		
		for(int next : curNode.childs) {
			// 활성화 되어있지 않다면
			if(!tree[next].isActive) continue;
			flag = false; 
			dfs(next);
		}
		
		if(flag) answer++; 
	}

}