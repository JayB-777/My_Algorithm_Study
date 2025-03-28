

import java.io.*;
import java.util.*;

class Main{
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.toCharArray()[j] - '0';
			}
		}
		
//		for(int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		

		List<Integer> resultList = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					resultList.add(dfs(i,j));
				}
			}
		}
		
		Collections.sort(resultList);
		System.out.println(resultList.size());
		for(int result : resultList) {
			System.out.println(result);
		}
		
		
	}
	
	static int dfs(int startX, int startY) {
		int result = 1;
		Queue<int[]>  queue = new LinkedList<>();
		queue.offer(new int[] {startX, startY});
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i = 0; i < 4; i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				if(nx >=0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					result++;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		return result;		
	}
}