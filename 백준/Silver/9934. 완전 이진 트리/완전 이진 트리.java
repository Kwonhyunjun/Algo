import java.io.*;
import java.util.*;

public class Main {

	static int N, arr[]; 
	static List<Integer>[] nodes;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int n = (int) Math.pow(2, N) - 1;
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		nodes = new List[N];
		for(int i=0; i<N; i++) {
			nodes[i] = new ArrayList(); 
		}
		
		solve(0, n-1, 0);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int num : nodes[i]) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
//			System.out.println(nodes[i]);
		}
		
		System.out.println(sb);
	}
	
	static void solve(int start, int end, int depth) {
		if(start == end) {
//			System.out.println("left Node :" + arr[start]);
			nodes[depth].add(arr[start]);
			return; 
		}
		
		int mid = (end + start) / 2;
//		System.out.printf("start : %d end : %d mid : %d\n", start, end, mid);
		
		solve(start, mid-1, depth+1);
		nodes[depth].add(arr[mid]);
		solve(mid+1, end, depth+1); 
	}

}