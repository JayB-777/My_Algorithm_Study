import java.lang.*;
import java.util.*;
import java.io.*;

class Solution
{
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int[][] map;
    public static int N;
    public static int[][] dist;
    
 	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];
            
            for(int i = 0; i < N; i++){
                String line = br.readLine();
            	for(int j = 0; j < N; j++){
                	map[i][j] = line.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            
            int result = dijkstra();
            System.out.println("#" + test_case + " " + result);
             
		}  
      
	}
    
    private static int dijkstra(){
    	PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, map[0][0]));
        dist[0][0] = map[0][0];
        
        while(!pq.isEmpty()){
        	Node current = pq.poll();
            int x = current.x;
            int y = current.y;
            int cost = current.cost;
            
            if(x == N - 1 && y == N - 1){
            	return cost;
            }
            
            for(int i = 0; i < 4; i++){
            	int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 00 && nx < N && ny < N){
                	int newCost = cost + map[nx][ny];
                    if(newCost < dist[nx][ny]){
                    	dist[nx][ny] = newCost;
                        pq.add(new Node(nx, ny, newCost));
                    }
                }
            }
        }
        return -1;
    }
    
    static class Node implements Comparable<Node>{
    	int x, y, cost;
        Node(int x, int y, int cost){
        	this.x = x;
            this.y = y;
            this.cost = cost;
        }
        
        public int compareTo(Node other){
			return this.cost - other.cost;
        }
    }
    
}