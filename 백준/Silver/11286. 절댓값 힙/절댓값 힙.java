import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1)==Math.abs(o2)) {
					return o1 - o2;
				}
				return Math.abs(o1)-Math.abs(o2);
			}
		});
		
		for(int i=0;i<N;i++) {
			int num = sc.nextInt(); 
			if(num == 0) {
//				System.out.println("0: " + pq);
				int ans = pq.peek() == null? 0 : pq.poll(); 
				System.out.println(ans);
			}else {
				pq.offer(num); 
//				System.out.println(num +" "+pq);
			}
		}
		
	}

}
