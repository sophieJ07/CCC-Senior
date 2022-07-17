import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//CCC '17 S2 - High Tide, Low Tide

public class S2_2017 {
	int length;
	int[] heights;
	
	public S2_2017() throws FileNotFoundException {
		var file = new File("Data/S2/2017");
		var in = new Scanner(file); 

		length = in.nextInt();
		heights = new int[length]; 
		for(int i=0;i<length;i++) {  
			heights[i] = in.nextInt(); 
		}
		
		Arrays.sort(heights);
	}
	
	public void solve() {
		int[] high = new int[length/2];
		int[] low = new int[length/2]; 
		
		for(int i=0; i< length/2;i++) {
			high[i] = heights[length/2 + i ];
		}
		for(int i=0; i<length/2; i++) {
			low[i] = heights[length/2 - i - 1]; 
		}
		
		for(int i=0;i<length/2; i++) {
			System.out.print(low[i] + " " + high[i] + " ");
		}
	}

}


