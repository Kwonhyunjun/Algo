import java.io.*;
import java.util.*;

public class Main {

	static int N, arr[];
	static ArrayList<Integer> lis; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N]; 
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		lis = new ArrayList<>();
		
		for(int elem : arr) {
			
			if(lis.isEmpty() || lis.get(lis.size()-1) < elem) {
				lis.add(elem);
				continue;
			}
			
			int idx = binary_search(elem); 
			lis.set(idx, elem);
		}
		
//		System.out.println(lis);
		System.out.println(lis.size());
		
	}

	static int binary_search(int elem) {
		int res = 0;
		
		int left = 0;
		int right = lis.size()-1; 
		
		while(left <= right) {
			int mid = (left + right) / 2; 
			
			if(lis.get(mid) >= elem) {
				res = mid;
				right = mid - 1; 
			}else {
				left = mid + 1; 
			}
		}
		
		return res; 
	}
}