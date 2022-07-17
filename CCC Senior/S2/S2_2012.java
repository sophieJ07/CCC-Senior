import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class S2_2012 {
	String number;
	int result = 0;
	HashMap<String, Integer> baseValues;
	
	public S2_2012() throws FileNotFoundException{
		var file = new File("Data/S2/2012");
		var in = new Scanner(file);
		number = in.next();
		
		baseValues = new HashMap<>();
		baseValues.put("I", 1);
		baseValues.put("V", 5);
		baseValues.put("X", 10);
		baseValues.put("L", 50);
		baseValues.put("C", 100);
		baseValues.put("D", 500);
		baseValues.put("M", 1000);
		
	}
	
	public void solve() {
		recur(0, number.length()-2);
		System.out.println(result);
	}
	
	public void recur(int previousBase, int index) {
		int currentNum = Integer.parseInt(number.substring(index, index+1));
		int currentBase = baseValues.get(number.substring(index+1, index+2));
		
		if(previousBase > currentBase) {
			result-= currentNum*currentBase;
		}else result += currentNum * currentBase;
			
		if(index == 0) return;
		else recur(currentBase, index-2);
	}
}
