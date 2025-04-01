

import java.util.*;
import java.io.*;

class Main{
	
	static int row;
	static int col;
	static int[][] map;
	// 상 하 좌 우 
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		visited = new boolean[row][col];
		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		
		int numOfPaint = 0;
		int biggestPaintSize = 1;
		
		for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int sizeOfPaint = bfs(i, j);
                    numOfPaint++;
                    biggestPaintSize = Math.max(biggestPaintSize, sizeOfPaint);
                }
            }
        }
		System.out.println(numOfPaint);
		if(numOfPaint == 0) {
			System.out.println(0);
		} else {
			System.out.println(biggestPaintSize);	
		}	
		
	}


	private static int bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		visited[startX][startY] = true;
		queue.offer(new int[] {startX, startY});
		int sizeOfPaint = 1;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			for(int i = 0; i < 4; i++) {
				int nx = currentX + dx[i];
				int ny = currentY + dy[i];
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
					sizeOfPaint++;
				}
			}
		}
		return sizeOfPaint;
	}
}
