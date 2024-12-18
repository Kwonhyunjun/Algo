import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			set1.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			set2.add(Integer.parseInt(st.nextToken()));
		}
		
		HashSet<Integer> set3 = new HashSet<>();
		
		for(int num : set1) {
			if(set2.contains(num)) {
				set3.add(num);
			}
		}
		
		for(int num : set3) {
			set1.remove(num);
			set2.remove(num);
		}
		
		System.out.println(set1.size()+set2.size());
		

	}

}