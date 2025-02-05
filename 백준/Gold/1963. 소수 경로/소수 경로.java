import java.io.*;
import java.util.*;

public class Main {
	
	static int T, cnt;
	static boolean prime[], v[];
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		prime = new boolean[10000];
		
		for(int i=0; i<10000; i++) {
			prime[i] = isPrime(i);
		}
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			char[] origin = st.nextToken().toCharArray();
			char[] target = st.nextToken().toCharArray();
			v = new boolean[10000];
			
			cnt = -1; 
			
			bfs(origin, target, changeNum(target));
			
			if(cnt == -1) {
				sb.append("Impossible"); 
			}else {
				sb.append(cnt);
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	static class Data{
		char[] numCharArray; 
		int num; 
		int change; 
		
		public Data(char[] numCharArray, int change) {
			this.numCharArray = numCharArray;
			this.num = changeNum(numCharArray); 
			this.change = change; 
		}
	}
	
	static void bfs(char[] origin, char[] target, int targetNum) {
		Queue<Data> q = new ArrayDeque<>();
		
		Data first = new Data(origin, 0);
		
		q.offer(first);
		v[first.num] = true;
		
		while(!q.isEmpty()) {
			Data cur = q.poll();
			
//			System.out.println("cur : " + cur.num);
			
			if(cur.num == targetNum) {
				cnt = cur.change;
				return; 
			}
			
			for(int digit = 0 ; digit < 4; digit++) {
				int curDigit = findDigit(cur.num, digit); 
				if(curDigit == findDigit(targetNum, digit)) continue; 
//				System.out.println("digit : " + digit);
				
				for(int i=0; i<10; i++) {
					if(digit == 0 && i == 0) continue;
					if(curDigit == i) continue; 
//					System.out.println("i : " + i);
					
					char[] next = new char[4];
					for(int j=0; j<4; j++) {
						next[j] = (digit == j) ? (char) (i+48) : cur.numCharArray[j];
					}
					
//					System.out.printf("%d번째 숫자 %d로 변경 = %s\n", digit, i, Arrays.toString(next));
					
					
					int number = changeNum(next);
					if(!prime[number]) continue; 
					if(v[number]) continue;
					
					q.offer(new Data(next, cur.change+1));
					v[number] = true; 
					
				}
			}
		}
	}
	
	static int changeNum(char[] numCharArray) {
		int res = 0; 
		for(int i=0; i<4; i++) {
			res += (numCharArray[i] - '0') * (int) Math.pow(10, (3-i));
		}
		return res; 
	}
	
	static int findDigit (int num, int cnt) {
		
		int first = num % (int) Math.pow(10, 4-cnt); 
		int second = (int) Math.pow(10, 4-cnt-1); 
		
//		System.out.println("findDigit : " + num + " " + cnt);
//		System.out.println(" -> " + first + "/" + second);
		int res = first / second;
//		System.out.println("res : " + res);
		
		return res; 
	}
	
	static boolean isPrime(int num) {
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		
		return true; 
	}

}