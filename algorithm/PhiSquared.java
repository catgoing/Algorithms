package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class PhiSquared {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayDeque<Microbe> que = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			que.add(new Microbe(i + 1, Long.parseLong(st.nextToken())));
		}
		
		while(que.size() > 1) {
			ArrayDeque<Microbe> nextQue = new ArrayDeque<>();
			
			while(!que.isEmpty()) {
				Microbe mic = que.poll();
				long micValue = mic.value; 
				if(!que.isEmpty() && que.peek().value <= mic.value) {
					micValue += que.poll().value;
				}
				
				if(!nextQue.isEmpty() && nextQue.peekLast().value <= mic.value) {
					micValue += nextQue.pollLast().value;
				}
				
				nextQue.add(new Microbe(mic.idx, micValue));
			}
			
			que = nextQue;
		}
		
		
		Microbe result = que.poll();
		
		System.out.println(result.value);
		System.out.println(result.idx);
		
	}

}

class Microbe {
	int idx;
	long value;
	
	public Microbe(int idx, long value) {
		this.idx = idx;
		this.value = value;
	}
}