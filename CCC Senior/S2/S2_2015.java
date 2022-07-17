import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//CCC '15 S2 - Jerseys

public class S2_2015 {
	int jerseyNum;
    int requestNum;
    char[] jerseys;
    File file;
    Scanner in;

    public S2_2015() throws FileNotFoundException{
        file = new File("Data/S2/2015");
        in = new Scanner(file);
        jerseyNum = in.nextInt();
        requestNum = in.nextInt();
        jerseys = new char[jerseyNum+1];
        for(int i = 1; i <= jerseyNum; i++){
            jerseys[i] = in.next().charAt(0);
        }
    }

    public void solve(){
        int result = 0;
        for(int i = 0; i < requestNum; i++){
            char size = in.next().charAt(0);
            int number = in.nextInt();

            if(jerseys[number] != 'N'){
                if(size == 'S' || jerseys[number] == size || (size=='M' && jerseys[number]=='L')){
                    result++;
                    jerseys[number] = 'N';
                }
            }
        }
        System.out.println(result);
    }
}
