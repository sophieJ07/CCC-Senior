import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S2_2008 {
	Scanner in;
    File file;

    public S2_2008() throws FileNotFoundException{
        file = new File("Data/S2/2008");
        in = new Scanner(file);
    }

    public void solve(){
        int radius;
        int result;
        double r;

        radius = in.nextInt();
        while(radius != 0){
            result = 0;
            r = (double) radius * radius;

            for(int i = 1; i <= radius; i++){
                result += (int)Math.sqrt(r - (double)i*i) + 1;
            }

            result = 4 * result + 1;
            System.out.println(result);

            radius = in.nextInt();
        }
    }
}
