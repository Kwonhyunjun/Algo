import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			int len = str.length();
			
			sb.append(str.charAt(0)).append(str.charAt(len-1)).append("\n");
		}

		System.out.println(sb);
	}

}