import java.util.*;

class Solution {
    private static final int[] dx = {-1,1,0,0};
    private static final int[] dy = {0,0,-1,1};
    
    public int[] solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> islandSizes = new ArrayList<>();
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visited[i][j] && maps[i].charAt(j) != 'X'){
                    int size = bfs(maps, visited, i, j);
                    islandSizes.add(size);
                }
            }
        }
        
        if(islandSizes.isEmpty()){
            return new int[] {-1};
        }
        
        Collections.sort(islandSizes);
        
        int[] result = new int[islandSizes.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = islandSizes.get(i);
        }
        
        return result;
        
    }
    
    private int bfs(String[] maps, boolean[][] visited, int startX, int startY){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        int size = 0;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            size += maps[x].charAt(y) - '0';
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length() &&
                  !visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        
        return size;
    }
}