import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		long W = Integer.parseInt(st.nextToken());
		long S = Integer.parseInt(st.nextToken());
		
		long case1 = (X + Y) * W; 
		
		long case2 = Math.min(X, Y) * S;		
		long diff = Math.abs(X-Y);
		long case2_1 = diff % 2 == 1 ? (diff-1) * S + W : diff * S;
		long case2_2 = diff * W;
		case2 += Math.min(case2_1, case2_2);
		
		System.out.println(Math.min(case1, case2));
		
		
	}

}