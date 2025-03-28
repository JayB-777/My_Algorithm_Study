

import java.util.*;
import java.io.*;

class Main{

	static int N; // 정점 개수 
	static int M; // 간선 개수
	static int V; // 시작 정점 번호	
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>(); 
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
			arr[e].add(s);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(arr[i]);
		}
		
		dfs(V);
		System.out.println();
		visited = new boolean[N + 1];
		
		bfs(V);
		
		
	}
	
	static void dfs(int current) {
		visited[current] = true;
		System.out.print(current + " ");
	
		for(int next : arr[current]) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			
			for(int next : arr[current]) {
				if(!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		
	}
}