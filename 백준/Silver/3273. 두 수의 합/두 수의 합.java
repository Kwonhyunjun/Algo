import java.io.*;
import java.util.*;

public class Main {
	
	static int N, arr[];
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); 
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		int x = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=0; i<N; i++) {
			int n = x - arr[i]; 
			
			if(map.containsKey(n)) {
				answer += (n == arr[i]) ? map.get(n) -1 : map.get(n);
				
//				System.out.printf("arr[i] : %d, n : %d(%d)\n", arr[i], n, map.get(i));
			}
		}
		
		System.out.println(answer/2);

	}

}