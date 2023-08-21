import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 2252. 줄세우
public class Main {

	static class Node {
		int data;
		Node next;

		public Node(int data, Main.Node next) {
			this.data = data;
			this.next = next;
		}

	}

	static int N, M;
	static Node[] adjList;
	static int[] inDegree;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new Node[N + 1];
		inDegree = new int[N + 1];
		v = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++; // 진입차수 증가
		}
		// Input End
		
		bfs(); 
	}

	static void bfs() {
		Queue<Integer> q = new ArrayDeque<Integer>();

		// 시작 정점 넣기
		for (int i = 1; i < N + 1; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
				v[i] = true;
			}
		}

		int size;
		while (!q.isEmpty()) {
			size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll(); 
				System.out.print(cur + " ");
				
				for(Node temp = adjList[cur]; temp != null; temp = temp.next) {
					inDegree[temp.data]--; 
					
					if(inDegree[temp.data] == 0) {
						q.offer(temp.data); 
						v[temp.data] = true; 
					}
				}
			}
		}
	}
}
