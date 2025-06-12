import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, A[], op[], max, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		op = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++)
			op[i] = Integer.parseInt(st.nextToken());

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		dfs(1, A[0]);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int count, int result) {

		if (count == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			
			if(op[i] < 1) continue;
			
			op[i]--;
			if(i == 0) dfs(count + 1, result + A[count]);
			else if(i == 1) dfs(count + 1, result - A[count]);
			else if(i == 2) dfs(count + 1, result * A[count]);
			else if(i == 3) dfs(count + 1, result / A[count]);
			op[i]++;		
		}
	}
}