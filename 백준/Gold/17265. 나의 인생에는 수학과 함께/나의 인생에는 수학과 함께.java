import java.io.*;
import java.util.*;

public class Main {
	
	static int N, min, max; 
	static char[][] map; 
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N]; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = st.nextToken().charAt(0); 
			}
		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		
		solve(0, 0, 0, 0, 0);
		
		System.out.println(max + " " + min);
	}
	
	static void solve(int idx, int r, int c, int calc, int oper) {
		
//		System.out.printf("%d %d %d %d %d\n", idx, r, c, calc, oper);
		
		int nextNum = 0;
		int nextOper = 0; 
		if(idx % 2 == 0) {
			// 숫자
			int num = map[r][c] - 48;
			
			switch(oper) {
			case 0 :
				nextNum = calc +num;
				break;
			case 1 :
				nextNum = calc -num;
				break;
			case 2 :
				nextNum = calc *num;
				break;
			
			}
			nextOper = oper; 
			
		}else {
			// 연산자 
			switch(map[r][c]) {
				case '+' :
					nextOper=0;
					break;
				case '-' :
					nextOper=1;
					break;
				case '*' :
					nextOper=2;
					break;
				
			}
			nextNum = calc; 
		}
		
		if(r == N-1 && c == N-1) {
			min = Math.min(min, nextNum);
			max = Math.max(max, nextNum);
			return; 
		}
		

//		System.out.println("nextNum " + nextNum);
		
		if(r+1 < N) solve(idx+1, r+1, c, nextNum, nextOper);
		if(c+1 < N) solve(idx+1, r, c+1, nextNum, nextOper);
		
	}

}