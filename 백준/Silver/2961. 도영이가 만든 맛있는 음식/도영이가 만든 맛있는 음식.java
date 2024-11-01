import java.io.*;
import java.util.*;

public class Main {

	static int N, ingredients[][], answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		ingredients = new int[N][2]; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			ingredients[i][0] = Integer.parseInt(st.nextToken());
			ingredients[i][1] = Integer.parseInt(st.nextToken());
		}
		
		answer = Integer.MAX_VALUE;
		solve(0, 0, 1, 0); 
		
		System.out.println(answer);

	}
	
	static void solve(int idx, int cnt, int sour, int bitter) {
		if(idx == N) {
			if(cnt == 0 ) return; 
			answer = Math.min(answer, Math.abs(sour-bitter)); 
			return; 
		}
		
		int[] cur = ingredients[idx]; 
		
		solve(idx+1, cnt+1, sour * cur[0], bitter + cur[1]);
		
		solve(idx+1, cnt, sour, bitter);
		
	}

}