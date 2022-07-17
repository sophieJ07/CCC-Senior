import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S2_2013 {
	int[] weights;
    int maxWeight;

    public S2_2013() throws FileNotFoundException{
        var file = new File("Data/S2/2013");
        var in = new Scanner(file);
        maxWeight = in.nextInt();
        int n = in.nextInt();
        weights = new int[n];
        for(int i = 0; i < n; i++){
            weights[i] = in.nextInt();
        }
    }

    public void solve(){
        int current = 0;
        int result = 0;
        for(int i = 0; i < 4; i++) {
            current += weights[i];
            if (current > maxWeight) break;
            result++;
        }
        if(result < 4){
            System.out.println(result);
        }else{

            for(int i = 4; i < weights.length; i++) {
                current -= weights[i-4];
                current += weights[i];
                if(current > maxWeight) break;
                result++;
            }
            System.out.println(result);
        }
    }
}
