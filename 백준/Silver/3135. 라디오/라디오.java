import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int n = Integer.parseInt(sc.next());
		int m = Math.abs(a-b);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(m-1);
		while(n-- > 0 ) {
			int cnt = 0 ; 
			int num = Integer.parseInt(sc.next());
			if( num >= b ) {
				while(num !=b ) {					
					cnt+=1;
					num--;
				}
			} else if( num < b){
				while(num!=b) {
					cnt+=1;
					num++;	
				}
			}
			
			pq.offer(cnt);
		}
		
		System.out.println(pq.poll()+1);
		
	}

}