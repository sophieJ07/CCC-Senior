import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S1_2010 {
	int n;
    Scanner in;

    public S1_2010() throws FileNotFoundException{
        var file = new File("Data/S1/2010");
        in = new Scanner(file);
        n = in.nextInt();
    }

    public void solve(){
        int max = 0;
        String maxName = "";
        int max2 = 0;
        String max2Name = "";

        for(int i = 0; i < n; i++){
            String name = in.next();
            int r = in.nextInt();
            int s = in.nextInt();
            int d = in.nextInt();

            int value = 2*r + 3*s + d;

            if(value > max){
                max2 = max;
                max2Name = maxName;
                max = value;
                maxName = name;
            }else if(value > max2){
                max2 = value;
                max2Name = name;
            }
        }

        if(n != 0) {
            if(n == 1)
                System.out.println(maxName);
            else{
                System.out.println(maxName);
                System.out.println(max2Name);
            }
        }
    }
}
