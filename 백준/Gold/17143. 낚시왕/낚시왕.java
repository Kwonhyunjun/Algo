import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R, C, M; 
	static List<Shark> list;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};
	
	static int ans; 

	static class Shark implements Comparable<Shark>{
		int no; 
		int r; // 행  
		int c; // 열
		int s; // 속력
		int d; // 이동방향
		int z; // 크기
		
		public Shark(int no, int r, int c, int s, int d, int z) {
			super();
			this.no = no;
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [no=" + no + ", r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

		@Override
		public int compareTo(Main.Shark o) {
			
			if(this.no == o.no) {
				return -(this.z - o.z);
			}
			
			return this.no - o.no;
		}
		
	}
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); // 상어의 수
		
		list = new ArrayList<>(); 
		ans = 0; 
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new Shark(C*(r-1)+(c-1),r,c,s,d,z));
		}
		
		// Input End 
		
		for(int t=1; t<=C; t++) {
//			if(t == 2) break; 
//			System.out.print(t + "초  - ");
			// 상어 낚시
			Collections.sort(list);
			for(int i=0; i<list.size(); i++) {
				Shark cur = list.get(i);
				if(cur.c == t) {
//					System.out.println("잡은 상어 크기 :"+cur.z);
					ans += cur.z; 
					list.remove(i); 
					i--;
					break; 
				}
			}
			
//			System.out.println(" 이동 전:"+list);
			// 상어 이동 : 방향 체크 -> 이동
			// 방향 체크
			int size = list.size();
			for(int i=0; i<size; i++) {
				Shark cur = list.get(i);
				
				move(cur); 
				
			}
//			System.out.println(" 이동 후 :"+list);
			
			// 같은 칸 상어 정리 
			Collections.sort(list);
			for(int i=0; i<list.size()-1 ; i++) {
				Shark cur = list.get(i);
				Shark next = list.get(i+1);
				
				if(cur.no == next.no) {
					list.remove(i+1);
					i--; 
				}
				
			}
			
			
		}
		System.out.println(ans);
	}

	private static void move(Main.Shark cur) {
//		System.out.println("현재 고려되고 있는 상어 : "+ cur);
		for(int i=0; i<cur.s; i++) {
			direction(cur);
			
			int d = cur.d;
			
			cur.r += dr[d];
			cur.c += dc[d];
			cur.no = C*(cur.r-1)+(cur.c-1); 
		}
		
	}

	private static void direction(Main.Shark cur) {
		if(cur.d == 1 && cur.r ==1) { // 상 -> 하
//			System.out.println("상 -> 하");
			cur.d = 2; 
		}
		if(cur.d == 2 && cur.r ==R) { // 하 -> 상
//			System.out.println("하 -> 상");
			cur.d =1; 
		}
		if(cur.d == 4 && cur.c ==1) { // 좌 -> 우 
//			System.out.println("좌 -> 우");
			cur.d = 3; 
		} 
		if(cur.d == 3 && cur.c ==C) { // 우 -> 좌 
//			System.out.println("우 -> 좌 ");
			cur.d =4; 
		}
	}


}