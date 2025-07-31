import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int stick = 64;
		int count = 0;

		while (N > 0) {
			if (stick > N) {
				stick /= 2;

			} else {
				N -= stick;
				count++;
			}
		}

		System.out.println(count);
		
	}

}
 