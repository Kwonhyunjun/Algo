import java.io.*;
import java.util.*;

public class Main {
	
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		List<int[]> villes = new ArrayList<>();
		
		long sum = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			villes.add(new int[] {a, b});
			sum += b;
		}
		
		Collections.sort(villes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		
		long middle = (sum+1) / 2;
		long left = 0;
		for(int i=0; i<villes.size(); i++) {
			int[] cur = villes.get(i);
			
			left += cur[1];
			if(left >= middle) {
				System.out.println(cur[0]); 
				break;
			}
		}
	}

}