import java.io.*;
import java.util.*;

public class Main {
	
	static int N, adjMatrix[][], v[];
	static List<Integer>[] adjList;
	static TreeMap<Integer, List<Integer>> map = new TreeMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		
		adjMatrix = new int[N][N];
		
		adjList = new List[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int isLike= Integer.parseInt(st.nextToken());
				if(isLike != 0) continue;
//				if(i == j) continue;
				adjList[i].add(j);
			}
		}
		
		v = new int[N+1];
		Arrays.fill(v, -1);
		
		boolean flag = true;
		
		for(int i=1; i<=N; i++) {
			if(v[i] != -1) {
				if(!check(i, v[i])) {
					flag = false;
					break;
				}
				continue;
			}
			if(!group(i)) {
				flag = false;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(!flag) {
			sb.append(0);
		}else {
			
			sb.append(map.size()).append("\n");
			
			for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
				for(int cur : entry.getValue()) {
					sb.append(cur).append(" ");					
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);

	}
	
	static boolean group(int n) {
		List<Integer> list = new ArrayList<>();
		
		for(int nxt : adjList[n]) {
			v[nxt] = n;
			list.add(nxt);
		}
		if(list.size() < 2) return false;
		map.put(n, list);
		return true;
	}
	
	static boolean check(int n, int g) {
		if(map.get(g).size() != adjList[n].size()) return false;
		
		for(int cur : adjList[n]) {
			if(!map.get(g).contains(cur)) return false;
		}
		
		return true; 
	}

}