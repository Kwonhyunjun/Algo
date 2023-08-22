import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 24479. 알고리즘 수업 - 깊이 우선 탐색 
public class Main {
	static int N, M, R;
	static List<Integer>[] adjList;
	static int[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 수
		M = Integer.parseInt(st.nextToken()); // 간선의 수
		R = Integer.parseInt(st.nextToken()); // 시작 정점

		adjList = new List[N + 1];
		v = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from].add(to);
			adjList[to].add(from);

		}
		// Input End

		// 정렬
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(adjList[i], new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return -(o1-o2);
				}
			});
		}

		dfs(R);

		for (int i = 1; i < N + 1; i++) {
			System.out.println(v[i]);
		}
	}
	static int depth = 1; 
	static void dfs(int start) {
		v[start] = depth;
		depth++; 

		for (int i = 0, size = adjList[start].size(); i < size; i++) {
			if (v[adjList[start].get(i)] == 0) {
				dfs(adjList[start].get(i));
			}
		}
	}

}
