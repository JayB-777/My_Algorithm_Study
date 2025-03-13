
import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String argas[]) throws IOException{
		PriorityQueue<Entity> pq = new PriorityQueue<>(
		            Comparator.comparingInt((Entity e) -> e.absoluteValue) // 1순위: 절대값 오름차순
		                      .thenComparingInt(e -> e.value) // 2순위: 원래 값 오름차순
		        );
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if(value == 0) {
				if(pq.size() == 0) {
					System.out.println("0");
				} else {
					System.out.println(pq.poll().value);
				}
			} else {
				pq.add(new Entity(value, Math.abs(value)));
			}
		}
		
		
	}
	
	static class Entity{
		int value;
		int absoluteValue;
		
		public Entity(int value, int absoluteValue) {
			this.value = value;
			this.absoluteValue = absoluteValue;
		}

	}
}


