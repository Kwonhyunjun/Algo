import java.io.*;
import java.util.*;

public class Main {
	
	static int N, arr[];
	static long fact[], K; 
	static StringBuilder sb = new StringBuilder();
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		fact = new long[N+1];
		arr = new int[N+1];
		
		fact[1] = 1;
		for(int i=2; i<N+1; i++) {
			fact[i] = fact[i-1] * i; 
		}
		
		list = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		int type = Integer.parseInt(st.nextToken());
		if(type == 1) {
			K = Long.parseLong(st.nextToken())-1;
			solve1(); 
			
		}else {
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			solve2();
		}
		System.out.println(sb);
	}
	
	static void solve1() {
		
		for(int i=1; i<N; i++) { // 현재 자릿수
			long f = fact[N - i];
			
			int idx = (int) (K / f);
			
			K %= f; 
			
			sb.append(list.get(idx)).append(" ");
			list.remove(idx);
		}
		
		sb.append(list.get(0));
	}
	
	static void solve2() {
		long cnt = 1;
		
		for(int i=1; i<N; i++) {
			int idx = list.indexOf(arr[i]);
			
			long f = fact[N-i];
			
			cnt += (idx * f);
			
			list.remove(idx);
		}
		
		sb.append(cnt);
	}

}