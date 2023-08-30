import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static ArrayList<Integer>[] adjList;
	static int[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		v = new int[N + 1];
		adjList = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from].add(to);
			adjList[to].add(from);

		}

		for (int i = 1; i < N + 1; i++) {
			Collections.sort(adjList[i]);
		}

		bfs(R);

		for (int i = 1; i < N + 1; i++) {
			System.out.println(v[i]);
		}

	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque();

		// 시작정점 삽입 & 방문 체크
		int vCnt = 1;
		q.offer(R);
		v[R] = vCnt;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 0, size = adjList[cur].size(); i < size; i++) {
				if (v[adjList[cur].get(i)] != 0)
					continue;
				v[adjList[cur].get(i)] = ++vCnt;
				q.offer(adjList[cur].get(i));
			}
		}

	}

}
