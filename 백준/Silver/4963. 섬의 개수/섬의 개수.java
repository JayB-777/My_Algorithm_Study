

import java.util.*;
import java.io.*;

class Main{
	
	static int row;
	static int col;
	static int[][] map;
	static boolean visited[][];
	// 8방향 탐색 
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			map = new int[row][col];
			visited = new boolean[row][col];
			
			if(col == 0 && row == 0) {
				break;
			}
			
			for(int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
	
			int numOfIsland = 0;
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						numOfIsland++;
					}
				}
			}
			System.out.println(numOfIsland);
			
		}while(true);
	}
	
	public static void bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		visited[startX][startY] = true;
		queue.offer(new int[] {startX, startY});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			
			for(int i = 0; i < 8; i++) {
				int nx = currentX + dx[i];
				int ny = currentY + dy[i];
				if(nx >= 0&& ny >= 0 && nx < row && ny < col && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
				}
			}
 		}
	}
	
}