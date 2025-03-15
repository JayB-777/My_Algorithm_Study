
import java.util.*;
import java.io.*;

public class Main{
	
	static boolean visited[];
	static List<Integer>[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		arr = new ArrayList[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		
		int result = 0;
		
		for(int i = 1; i < N + 1; i++) {
			if(!visited[i]) {
				result++;
				dfs(i);
			}
			
		}
		System.out.println(result);
		
	}

	private static void dfs(int currentNode) {
		if(visited[currentNode]) {
			return;
		}
		visited[currentNode] = true;
		for(int i : arr[currentNode]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		
	}
}