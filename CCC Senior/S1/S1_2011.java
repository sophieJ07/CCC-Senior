import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S1_2011 {
	int n;
    String[] lines;

    public S1_2011() throws FileNotFoundException{
        var file = new File("Data/S1/2011");
        var in = new Scanner(file);
        n = in.nextInt();
        lines = new String[n];

        for(int i = 0; i < n; i++){
            lines[i] = in.nextLine();
        }
    }

    public void solve(){
        int s = 0;
        int t = 0;

        for(String line : lines){
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == 's' || line.charAt(i) == 'S'){
                    s++;
                }else if(line.charAt(i) == 't' || line.charAt(i) == 'T'){
                    t++;
                }
            }
        }

        if(t>s) System.out.println("English");
        else System.out.println("French");
    }
}
