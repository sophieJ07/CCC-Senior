import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//CCC '18 S1 - Voronoi Villages

public class S1_2018 {
    int[] points;
    int length;

    public S1_2018() throws FileNotFoundException {
        var file = new File("Data/S1/2018");
        Scanner in = new Scanner(file);
        length = in.nextInt();
        points = new int[length];
        for(int i = 0; i < length; i++){
            points[i] = in.nextInt();
        }
        Arrays.sort(points);
    }

    public void solve(){
        double left, right;
        double minSize = Integer.MAX_VALUE;
        for(int i = 1; i < length-1; i++){
            left = (points[i]-points[i-1])/2.0;
            right = (points[i+1]-points[i])/2.0;
            if((left + right) < minSize) minSize = left + right;
        }
        System.out.println(minSize);
    }

}

