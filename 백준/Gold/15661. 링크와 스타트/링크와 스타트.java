import java.io.*;
import java.util.*;

public class Main {
	
	static int N, map[][], answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N]; 
		answer = Integer.MAX_VALUE; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N/2; i++) {
//			System.out.println("i : "+i); 
			combi(i, 0, 0);
		}
		
		System.out.println(answer);
	}
	
	static List<Integer> list = new ArrayList<>();
	
	static void combi(int select, int cnt, int start) {
		if(select == cnt) {
			List<Integer> another = new ArrayList<>();
			for(int i=0; i<N; i++) {
				if(!list.contains(i)) another.add(i); 
			}
			
			int s1 = calc(list); 
			int s2 = calc(another);
			
			answer = Math.min(answer, Math.abs(s1 - s2)); 
			return; 
		}
		
		for(int i=start; i<N; i++) {
			list.add(i); 
			combi(select, cnt+1, i+1); 
			list.remove(list.size()-1);
		}
	}
	
	static int calc(List<Integer> list) {
		int res = 0; 
		
		for(int i=0; i<list.size(); i++) {
			int cur = list.get(i);
			int idx = i-1;
			while(idx >= 0) {
				int num = list.get(idx--);
				res += map[cur][num]; 
				res += map[num][cur]; 
			}
		}
		
		return res; 
	}

}