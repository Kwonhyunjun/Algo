import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(sc.readLine());
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			ans += num * num; 
		}

		System.out.println(ans %10);
	}

}