import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S1_2008 {
	File file;
    Scanner in;

    public S1_2008() throws FileNotFoundException{
        file = new File("Data/S1/2008");
        in = new Scanner(file);
    }

    public void solve(){
        int temp;
        int coldest;
        String city;
        city = in.next();

        String coldestCity = city;
        coldest = in.nextInt();

        while(!city.equals("Waterloo")){
            city = in.next();
            temp = in.nextInt();
            if(temp<coldest){
                coldest = temp;
                coldestCity = city;
            }
        }
        System.out.println(coldestCity);

    }
}


