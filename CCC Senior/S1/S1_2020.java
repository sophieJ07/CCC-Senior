import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
//CCC '20 S1 - Surmising a Sprinter's Speed

public class S1_2020 {
	TreeMap <Integer, Integer> observations = new TreeMap<>();
	
	public S1_2020() throws FileNotFoundException {
		var file = new File("Data/S1/2020");
		var in = new Scanner(file);
        int n = in.nextInt();
        for(int i=0; i<n; i++) {
        	observations.put(in.nextInt(), in.nextInt());
        }
	}
	
	public void solve() {
		float max = 0;
		int pTime = observations.firstKey();
		int pPos = observations.get(pTime); 
		
		for(Integer t : observations.keySet()) {
			int time = t;
			int pos = observations.get(t);
			
			int diff = time-pTime;
			int distance = Math.abs(pos-pPos);
			float speed = (float)distance/diff;
			if(speed>max) max = speed; 
			
			pTime = time;
			pPos = pos;
		}
		
		System.out.println(max);
	}
}
