import java.io.*;
import java.util.*;

public class Main {
	
	static int N, W, L, answer;
	static Queue<Truck> trucks, bridge;
	
	static class Truck{
		int weight, time; 
		
		public Truck(int weight) {
			this.weight = weight; 
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());  
		
		N = Integer.parseInt(st.nextToken()); // 트럭의 수 
		W = Integer.parseInt(st.nextToken()); // 다리의 길이
		L = Integer.parseInt(st.nextToken()); // 다리의 하중
		
		
		trucks = new ArrayDeque<>();
		bridge = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			trucks.offer(new Truck(Integer.parseInt(st.nextToken()))); 
		}
		
		int curTime = 0; 
		int curWeight = 0; // 현재 다리 위 트럭의 무게
		
		while(!(trucks.isEmpty() && bridge.isEmpty())) {
//			System.out.println(curTime + "  "+ trucks.size() + " " + bridge.size() );
			
			// 나가는 트럭
			while(!bridge.isEmpty() && bridge.peek().time == curTime) {
				curWeight -= bridge.poll().weight; 
			}
			
			// 들어가는 트럭
			if(!trucks.isEmpty() && (curWeight + trucks.peek().weight) <= L) {
				Truck enter = trucks.poll(); 
				curWeight += enter.weight; 
				enter.time += (curTime + W);
				bridge.offer(enter); 
			}
			
			curTime++; 
			
		}
		
		answer = curTime;
		System.out.println(answer);
		
		

	}

}