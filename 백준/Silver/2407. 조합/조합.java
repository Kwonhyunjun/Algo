import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
	
	static int N, M;
	static BigInteger[] memo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		memo = new BigInteger[101];
		Arrays.fill(memo, new BigInteger("0"));
		memo[1] = new BigInteger("1"); 
		
		BigInteger answer =  fact(N).divide((fact(N-M).multiply(fact(M))));
		
//		System.out.println(fact(N));
//		System.out.println(Arrays.toString(memo));
//		System.out.println(fact(N-M));
//		System.out.println(fact(M));
		
		System.out.println(answer);

	}
	
	static BigInteger fact(int num) {
//		System.out.println(num);
//		System.out.println(memo[num]);
		

		if("1".equals(memo[num].toString()) ) {
			return memo[num];
		}
//		System.out.println(fact(num-1).multiply(new BigInteger(num + "")));
		return memo[num] = fact(num-1).multiply(new BigInteger(num + ""));
	}

}