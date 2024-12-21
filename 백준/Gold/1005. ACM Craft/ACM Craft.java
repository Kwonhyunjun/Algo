/**
 * 문제조건
 * 1. 건물을 짓는 순서가 주어지고 모든 건물은 짓기 시작하고 완성 때까지 Delay가 존재한다.
 * 2. 건물을 짓기 위해서는 선행 건물이 다 지어져야 건설이 가능하다
 * 
 * 출력값 : 특정 건물을 가장 빨리 지을 때까지 걸리는 최소 시간
 * 
 * 입력 조건
 * 2 <= 건물의 개수(노드) <= 1000
 * 1 <= 건물 규칙(간선) <= 100000
 * 
 * 알고리즘 : 위상정렬 (선행되야하는 건물 짓기 순서가 정해져있기 때문에)
 * 자료구조
 * 	1. ArrayList<Integer>[] adjList : 건물과 선행되어야 하는 정보를 나타내는 그래프
 *  2. int[] indgreeCnt : 각 건물 당 indgree 개수를 저장
 *  3. Class Building : 현재 짓고 있는 건물 정보
 *  4. PriorityQueue<Building> pq : 건물 짓는 진행상황을 저장한 우선순위 큐 (끝나는 순서대로 정렬)
 *  5. int time : 현재 시간
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	
	static int T, N, K, time, target, indgree[], duration[];
	static ArrayList<Integer>[] adjList;
	static PriorityQueue<Building> pq; 
	static class Building{
		int num, start, end; 
		
		public Building(int num, int start, int end) {
			this.num = num; 
			this.start = start;
			this.end = end; 
		}
		
		public String toString(){
			return "Num : " + num + " start : " + start + " end : " + end; 
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		
			st = new StringTokenizer(br.readLine());
			duration = new int[N+1];
			for(int i=1; i<=N; i++) {
				duration[i] = Integer.parseInt(st.nextToken());
			}
			
			pq = new PriorityQueue<>((o1, o2) -> o1.end - o2.end); 
			
			indgree = new int[N+1];
			adjList = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int prev = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				
				adjList[prev].add(next);
				indgree[next]++; 
			}
			
			
			target = Integer.parseInt(br.readLine());
			
			time = 0; 
			
			for(int i=1; i<=N; i++) {
				if(indgree[i] == 0) {
					pq.offer(new Building(i, time, time+duration[i])); 
					indgree[i] = -1; 
				}
			}
			
			while(!pq.isEmpty()) {
				Building cur = pq.poll();

				time = cur.end; 
				
				if(cur.num == target) {
					sb.append(time).append("\n");
					break;
				}
				
				for(int next : adjList[cur.num]) {
					indgree[next]--; 
				}
				for(int i=1; i<=N; i++) {
					if(indgree[i] == 0) {
						pq.offer(new Building(i, time, (time+duration[i]))); 
						indgree[i] = -1; 
					}
				}
			}
			
		}
		
		System.out.println(sb);
		
		
	}

	
}