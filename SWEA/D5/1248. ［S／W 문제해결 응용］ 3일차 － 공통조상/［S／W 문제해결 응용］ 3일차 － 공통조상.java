import java.io.*;
import java.util.*;

public class Solution {
	
	static int v, e, x, y;
	static int[] par; // 부모노드 저장 배열 
	static int[] sz;  // 서브트리 사이즈 저장 배열
	
	static ArrayList<Integer>[] child = new ArrayList[10010]; 
	
	
	
	public static void dfs(int cur) {
		sz[cur] = 1; 
		
		for(int i=0; i<child[cur].size(); i++) {
			dfs(child[cur].get(i));
			
			sz[cur] += sz[child[cur].get(i)]; 
		}
	}
	
	// prv : 내가 어느 노드로 부터 왔는지 확인(즉, 현재노드 cur의 부모노드)
	public static void dfs(int cur, int prv){
		for(int i=0; i<child[cur].size(); i++){
			if(child[cur].get(i) == prv) continue; // 만약 부모노드로 돌아가려 한다면 스킵
			
			dfs(child[cur].get(i), cur);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine()); 

		
		for(int t=1; t<T+1; t++) {
			
			ArrayList<Integer> v1 = new ArrayList<>(); 
			ArrayList<Integer> v2 = new ArrayList<>(); 
			
			st = new StringTokenizer(br.readLine()); 
			
			v = Integer.parseInt(st.nextToken()); 
			e = Integer.parseInt(st.nextToken()); 
			x = Integer.parseInt(st.nextToken()); 
			y = Integer.parseInt(st.nextToken()); 
			
			par = new int[v+1]; // 부모노드 저장 배열
			sz = new int[v+1]; // 서브트리 사이즈 저장 배열
			for(int i=1; i<v+1; i++) {
				child[i] = new ArrayList<>(); 
			}
			
			st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<e; i++) {
				int a = Integer.parseInt(st.nextToken()); 
				int b = Integer.parseInt(st.nextToken());
				
				par[b] = a;
				child[a].add(b); 
			}

			int cur = x; 
			while(cur != 0) {
				v1.add(cur); 
				cur = par[cur]; 
			}
			
			cur = y; 
			while(cur != 0) {
				v2.add(cur); 
				cur = par[cur]; 
			}
			
			int idx1 = v1.size()-1;
			int idx2 = v2.size()-1;
			int ans = 1; 
			while(idx1 >= 0 && idx2 >= 0) {
				if(v1.get(idx1).equals(v2.get(idx2))) ans = v1.get(idx1); 
				idx1--; 
				idx2--;
			}
			
			dfs(1); 
			
			System.out.println("#"+t+" "+ans+" "+sz[ans]);
		}// test_case 
		
	}

}