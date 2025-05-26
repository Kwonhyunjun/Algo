import java.io.*; 
import java.util.*;
	
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		boolean found = false;
		StringBuilder sb = new StringBuilder();
		
		for(int l=L; l<=100; l++) {
			int child = 2 * N - l * (l - 1);
			int parent = 2 * l;
			
			if(child % parent == 0) {
				int a = child / parent; 
				
				if(a >= 0) {
					found = true;
					for(int i=0; i<l; i++) {
						sb.append(a+i).append(" ");
					}
					break;
				}
			}
		}

		System.out.println((found) ? sb.toString() : -1);
	}

}