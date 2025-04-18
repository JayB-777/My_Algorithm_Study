

import java.util.*;
import java.io.*;

public class Main{
	
	// 상 하 좌 우
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static int[][] maze;
	static boolean[][] visited;
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}
		int result = bfs(0,0);
		
		System.out.println(result);
		
	}

	private static int bfs(int x, int y) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()){
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] == 1 && !visited[nx][ny]) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					maze[nx][ny] = maze[cx][cy] + 1;  
				}
			}
		}
		return maze[N - 1][M - 1];
	}
	
}