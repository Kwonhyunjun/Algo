import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N+1];

		for (int i = 0; i < N+1; i++) {
			nums[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(m == 0) { // 합집합 
				union(a, b);
			}else { // 두 집합이 같은 집합인지 확인
				String str = (check(a, b)? "YES" : "NO");
				System.out.println(str);
			}
		}

	}

	private static boolean check(int a, int b) {
		if(find(a) == find(b)) return true; 
		
		return false; 
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return; 
		
		nums[b] = a; 
	}

	private static int find(int a) {
		if(nums[a] == a) return nums[a]; 
		return nums[a] = find(nums[a]);
	}
	
	

}