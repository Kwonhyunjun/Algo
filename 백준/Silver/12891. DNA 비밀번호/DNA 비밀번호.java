import java.io.*;
import java.util.*;

public class Main {
	
	static int S, P, cur[], alpha[], answer;
	static String str;
	static HashMap<Character, Integer> map; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		str = br.readLine();
		
		alpha = new int[4];
		cur = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			alpha[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		
		for(int i=0; i<P; i++) {
			cur[map.get(str.charAt(i))]++;
		}
		
		if(check()) answer++; 
		
		for(int i=P; i<S; i++) {
//			System.out.println(Arrays.toString(cur));
//			System.out.println(str.charAt(i));
//			System.out.println(str.charAt(i-P));
			cur[map.get(str.charAt(i))]++;
			cur[map.get(str.charAt(i-P))]--;
			
			if(check()) answer++; 
		}
		
		System.out.println(answer);
		
	}
	
	static boolean check() {
		for(int i=0; i<4; i++) {
			if(cur[i] - alpha[i] < 0) {
				return false;
			}
		}
		return true;
	}

}