import java.util.*;
import java.io.*;
import java.lang.*;

class Solution
{
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int t = Integer.parseInt(br.readLine());
            int[][] map = new int[16][16];
            boolean[][] visited = new boolean[16][16];
            int startX = 0;
            int startY = 0;
            
            for(int i = 0; i < 16; i++){
                String line = br.readLine();
            	for(int j = 0; j < 16; j++){
                    if(line.charAt(j) - '0' == 2){
                    	startX = i;
                        startY = j;
                    }
                	map[i][j] = line.charAt(j) - '0';
                }
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            if(isValidMap(startX, startY, map, visited)){
            	sb.append(1);
            } else {
				sb.append(0);
            }

            System.out.println(sb);
            
		}
	}
    
    private static boolean isValidMap(int startX, int startY, int[][] map, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        
        while(!queue.isEmpty()){
        	int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            if(map[x][y] == 3){
            	return true;
            }
            
            for(int i = 0; i < 4; i++){
            	int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < 16 && ny >=0 && ny < 16 && map[nx][ny] != 1 && !visited[nx][ny]){
                	visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}