import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N]; 
		StringBuilder original = new StringBuilder();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			arr[i] = str;
			original.append(str);
		}
		
		StringBuilder desc = new StringBuilder();
		Arrays.sort(arr, Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			desc.append(arr[i]);
		}

		StringBuilder asc = new StringBuilder();
		Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			asc.append(arr[i]);
		}
		
		if(original.toString().equals(desc.toString())) {
			System.out.println("DECREASING");
		}else if(original.toString().equals(asc.toString())) {
			System.out.println("INCREASING");
		}else {
			System.out.println("NEITHER");
		}
	}

}