import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		
		char cur = arr[0];
		
		int cnt0 = cur == '0' ? 1 :0;
		int cnt1 = cur == '1' ? 1 :0;
		
		for(char c : arr) {
			if(cur != c) {
				cur = c;
				if(c == '1') {
					cnt1++;
				}else {
					cnt0++;
				}
			}
		}
		
		System.out.println(Math.min(cnt1, cnt0));

	}

}