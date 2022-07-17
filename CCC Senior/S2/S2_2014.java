import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class S2_2014 {
	int students;
    HashMap<String, String> pairs;
    String[] f,s;

    public S2_2014() throws FileNotFoundException{
        var file = new File("Data/S2/2014");
        var in = new Scanner(file);
        students = in.nextInt();

        f = new String[students];
        s = new String[students];
        for(int i = 0; i < students; i++){
            f[i] = in.next();
        }
        for(int i = 0; i < students; i++){
            s[i] = in.next();
        }

        pairs = new HashMap<>();
        
    }

    public void solve(){
    	for(int i = 0; i < students; i++){
            pairs.put(f[i], s[i]);
            if(pairs.containsKey(s[i]) && pairs.containsValue(f[i])) {
            	pairs.remove(f[i]);
            	pairs.remove(s[i]); 
            }else pairs.put(s[i], f[i]);
            
        }
    	
    	if(pairs.isEmpty()) System.out.println("good");
    	else System.out.println("bad");
    }
}
