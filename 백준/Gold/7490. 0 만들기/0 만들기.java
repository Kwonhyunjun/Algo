import java.io.*;
import java.util.*;


public class Main {

	static int T, N, answer;
	static char[] oper;
	static StringBuilder sb; 
	static List<String> operRes;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			
			oper = new char[N-1];
			operRes = new ArrayList<>(); 
			
			answer = 0;
			solve(0);
			Collections.sort(operRes);
			for(String cur : operRes) {
				sb.append(cur).append("\n");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void solve(int cnt) {
		if(cnt == N-1) {
			if(calc() == 0) {
				StringBuilder temp2 = new StringBuilder();
//				System.out.println("oper : " + Arrays.toString(oper));
				for(int i=0 ; i<N; i++) {
					
					temp2.append(i+1);
					if(i < N-1) {
						temp2.append(oper[i]);
					}
				}
				operRes.add(temp2.toString());
			}
			
			
			return;
		}
		
		oper[cnt] = '+';
		solve(cnt+1); 
		
		oper[cnt] = '-';
		solve(cnt+1); 
		
		oper[cnt] = ' ';
		solve(cnt+1); 
	}
	
	static int calc() {
		
		List<Integer> nums = new ArrayList<>();
		
		StringBuilder temp = new StringBuilder();
		temp.append("1");
		int num = 2;
		
		for(int i=0; i<N-1; i++) {
			if(oper[i] == ' ') {
				temp.append(num++);
			}else {
//				System.out.println("temp: " + temp);
				nums.add(Integer.parseInt(temp.toString()));
				temp.setLength(0);
				temp.append(num++);
			}
		}
		
		if(temp.length() > 0) nums.add(Integer.parseInt(temp.toString()));
		
		
//		System.out.println("nums : " + nums);
//		System.out.println();
		
		int res = nums.get(0);
		int idx = 1; 
		
		for(int i=0; i<N-1; i++) {
			if(oper[i] == ' ') continue;
			
			if(oper[i] == '+') {
				res += nums.get(idx);
			}else {
				res -= nums.get(idx);
			}
			
			idx++; 
		}
		
		return res; 
	}
	
}