import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static long B;
	static HashMap<Long, int[][]> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
	
		int[][] arr = new int[N][N];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = (Integer.parseInt(st.nextToken()) % 1000);
			}
		}
		
		map.put(1L, arr);

		solve(B);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(map.get(B)[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	
	static void multiple(long n1, long n2){
		
		int[][] arr1 = map.get(n1);
		int[][] arr2 = map.get(n2);
		
		int[][] newArr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int res = 0;
				for(int k=0; k<N; k++) {
					res += arr1[i][k] * arr2[k][j];
				}
				newArr[i][j] = (res % 1000);
			}
		}
		
		map.put(n1+n2, newArr);
	}
	
	static void solve(long n) {
		if(n <= 1) return;
		if(map.containsKey(n)) {
			return;
		}
		
		long divide = n / 2;
//		System.out.println(divide + " " + (n - divide));
		
		solve(divide);
		solve(n - divide);
		
		multiple(divide, n-divide);
	}

	
}