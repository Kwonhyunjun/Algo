import java.io.*;
import java.util.*; 

public class Main {
	
	static int red, blue; 
	static String str;
	static List<Data> list; 
	
	static class Data{
		char color; 
		int cnt; 
		
		public Data(char color, int cnt) {
			this.color = color; 
			this.cnt = cnt; 
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int N = Integer.parseInt(br.readLine()); 
		str = br.readLine(); 
		
		list = new ArrayList<>(); 
		
		list.add(new Data(str.charAt(0), 1));
		
		if(str.charAt(0) == 'R') {
			red++; 
		}else {
			blue++; 
		}
		
		for(int i=1; i<N; i++) {
			Data prev = list.get(list.size()-1);
			char cur = str.charAt(i);
			
			if(cur == 'R') {
				red++; 
			}else {
				blue++; 
			}
			
			if(prev.color == cur) {
				prev.cnt++; 
			}else {
				list.add(new Data(cur, 1));
			}
		}
		
		for(int i=0; i<list.size(); i++) {
//			System.out.printf("%c %d\n", list.get(i).color, list.get(i).cnt);
		}
		
//		System.out.printf("%d %d\n", red, blue);
		
		
		// 왼쪽
		int left = 0; 
		if(list.get(0).color == 'R') {
			left = Math.min(blue, red - list.get(0).cnt); 
		}else {
			left = Math.min(red, blue - list.get(0).cnt);
		}
		
		int right = 0; 
		if(list.get(list.size()-1).color == 'R') {
			right = Math.min(blue, red - list.get(list.size()-1).cnt);
		}else {
			left = Math.min(red, blue - list.get(list.size()-1).cnt);
		}
		
//		System.out.printf("left(%d), right(%d)\n", left, right); 
		
		System.out.println(Math.min(left, right)); 
	}

}