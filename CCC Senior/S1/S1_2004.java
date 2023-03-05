import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S1_2004 {
	Scanner in;
    int n;

    public S1_2004() throws FileNotFoundException{
        var file = new File("Data/S1/2004");
        in = new Scanner(file);
        n = in.nextInt();
    }

    public void solve(){
        String a;
        String b;
        String c;


        for(int i = 0; i < n; i++){
            a = in.next();
            b = in.next();
            c = in.next();

            if(startsWith(b, a) || startsWith(c, a) || endsWith(b, a) || endsWith(c, a) ||
            startsWith(a, b) || startsWith(c, b) || endsWith(a, b) || endsWith(c, b) ||
            startsWith(a, c) || startsWith(b, c) || endsWith(a, c) || endsWith(b, c)){
                System.out.println("No");
            }else System.out.println("Yes");

        }

    }

    public boolean startsWith (String s1, String s2){
        if(s2.length() <= s1.length() && s2.equals(s1.substring(0, s2.length()))) return true;
        return false;
    }

    public boolean endsWith (String s1, String s2){
        if(s2.length() <= s1.length() && s2.equals(s1.substring(s1.length() - s2.length()))) return true;
        return false;
    }
}
