import java.io.*;
import java.util.*;

public class Main {
	
	static int start, end; 
	static boolean v[];
	
	static class Data{
		int num;
		String str; 
		
		public Data(int num) {
			this.num = num;
		}
		
		public Data(int num, String str) {
			this.num = num;
			this.str = str;
		}
	}
	
	static int[] toArray(int num) {
		int[] res = new int[4];
		
		int idx = 0;
		while(num > 0) {
			res[3-idx] = num%10;
			num/=10;
			idx++;
		}

		return res;
	}
	
	static int toInt(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for(int num : nums) {
			sb.append(num);
		}
		return Integer.parseInt(sb.toString());
	}
	
	static int moveL(int nums) {
//		System.out.println(nums%1000);
//		System.out.println(nums/1000);
		
		return (nums%1000)*10 + (nums/1000);
	}
	
	static int moveR(int nums) {
//		System.out.println(nums/10);
//		System.out.println(nums%10);
		
		return (nums/10) + (nums%10)*1000;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			v = new boolean[10000];
			
//			System.out.println(moveR(1234));
			System.out.println(bfs(start));
			
		}

	}

	static String bfs(int start) {
		Queue<Data> q = new ArrayDeque<>();
		
		q.offer(new Data(start, new String())); 
		v[start] = true;
		
		while(!q.isEmpty()) {
			
			Data cur = q.poll();
			StringBuilder curSb = new StringBuilder(cur.str);
//			System.out.println(cur.num);
			
			if(end == cur.num) {
				return curSb.toString();
			}
			
			int nxtNum;
			 
			// L
			nxtNum = moveL(cur.num);
			
//			System.out.println("L : " + nxtNum);

			if(!v[nxtNum]) {
				curSb.append("L");
				v[nxtNum] = true;
				q.offer(new Data(nxtNum, curSb.toString()));
				curSb.setLength(curSb.length()-1);
			}		
			
			// R
			nxtNum = moveR(cur.num);
//			System.out.println("R : " + nxtNum);

			if(!v[nxtNum]) {
				curSb.append("R");
				v[nxtNum] = true;
				q.offer(new Data(nxtNum, curSb.toString()));
				curSb.setLength(curSb.length()-1);
			}
			
			// D
			nxtNum = cur.num * 2 % 10000;
//			System.out.println("D : " + nxtNum);

			if(!v[nxtNum]) {
				curSb.append("D");
				v[nxtNum] = true;
				q.offer(new Data(nxtNum, curSb.toString()));
				curSb.setLength(curSb.length()-1);
			}
			
			// S
			nxtNum = cur.num -1;
			if(nxtNum < 0) nxtNum += 10000;
//			System.out.println("S : " + nxtNum);
			
			if(!v[nxtNum]) {
				curSb.append("S");
				v[nxtNum] = true;
				q.offer(new Data(nxtNum, curSb.toString()));
				curSb.setLength(curSb.length()-1);
			}
			
		}
		
		return null;
	}
	
}