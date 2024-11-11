import java.io.*;
import java.util.*;

public class Main {

	static int R, C; 
	static StringBuilder[] cols; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		cols = new StringBuilder[C];
		
		for(int i=0; i<C; i++) {
			cols[i] = new StringBuilder(); 
		}
		
		for(int i=0; i<R; i++) {
			String str = br.readLine(); 
			
			for(int j=0; j<C; j++) {
				cols[j].append(str.charAt(j)); 
			}
		}
		
//		for(int i=0; i<C; i++) {
//			System.out.println(cols[i] + " " + i);
//		}
		
		int cnt = 0; 
		for(int i=1; i<R; i++) {
			HashSet<String> set = new HashSet<>(); 
			boolean flag = false; 
			
			for(int j=0; j<C; j++) {
//				System.out.println(cols[j].substring(i));
				if(!set.add(cols[j].substring(i))) {
//					System.out.println("중복");
					flag = true;
					break;
				}
			}
			
			if(flag) break; 
			cnt++; 
		}
		
		System.out.println(cnt);
	}

}