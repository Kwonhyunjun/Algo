import java.io.*;
import java.util.*;

public class Main {

	static int child, parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] fractions = new int[2][2];
		
		for(int i=0; i<2; i++) {
			st = new StringTokenizer(br.readLine());
			
			fractions[i][0]  = Integer.parseInt(st.nextToken());
			fractions[i][1]  = Integer.parseInt(st.nextToken());
		}
		
		child = fractions[0][0] * fractions[1][1] + fractions[1][0] * fractions[0][1];
		parent = fractions[1][1] * fractions[0][1];
		
		int gcd = gcd(child, parent);
		System.out.println((child/gcd) + " " + (parent/gcd));
		

	}
	
	public static int gcd(int a, int b) {
        // a가 b보다 큰 경우에 대해서 유클리드 호제법 수행.
        if (a <= b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (b == 0) {
            return a;
        }
        return gcd(b , a % b);
    }

}