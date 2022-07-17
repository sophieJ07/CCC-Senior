import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class S2_2010 {
	int k;
    HashMap<String, String> codes;
    String sequence;
    int maxLength;
    int minLength;

    public S2_2010() throws FileNotFoundException{
        var file = new File("Data/S2/2010");
        var in = new Scanner(file);

        k = in.nextInt();
        codes = new HashMap<>();

        maxLength = 0;
        minLength = Integer.MAX_VALUE;

        for(int i = 0; i < k; i++){
            String letter = in.next();
            String s = in.next();
            codes.put(s, letter);

            if(s.length() < minLength) minLength = s.length();
            if(s.length() > maxLength) maxLength = s.length();
        }
        sequence = in.next();
    }

    public void solve(){
    	System.out.println(recur(sequence));
    }

    public String recur(String remainingSequence){
        if(codes.containsKey(remainingSequence)){
            return codes.get(remainingSequence);
        }
        
        for(int i = minLength; i <= maxLength; i++) {
        	if(codes.containsKey(remainingSequence.substring(0, i))) {
        		return codes.get(remainingSequence.substring(0, i)) + recur(remainingSequence.substring(i));
        	}
        }
        return null;
    }
}
