

import java.util.*;
import java.io.*;


class Main{
	
	static int[][] map;
	static int M;
	static int K;
	static int X;
	// 상 하 좌 우 
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[M][K];
			visited = new boolean[M][K];
			for(int j = 0; j < X; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
//			for(int[] row: map) {
//				System.out.println(Arrays.toString(row));
//			}
			
			int result = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < K; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        bfs(j, k);
                        result++; 
                    }
                }
            }
            
            System.out.println(result);

		}	
		
	}
	
	public static void bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{startX, startY});
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			for(int i = 0; i < 4; i++) {
				int nx = currentX + dx[i];
				int ny = currentY + dy[i];
				if(nx >= 0 && ny >= 0 && nx < M && ny < K && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	
	
}