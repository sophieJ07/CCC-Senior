import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//CCC '15 S1 - Zero That Out

public class S1_2015 {
	int[] commands;
    int k;

    public S1_2015() throws FileNotFoundException {
        var file = new File("Data/S1/2015");
        var in = new Scanner(file);

        k = in.nextInt();
        commands = new int[k];
        for(int i = 0; i < k; i++) {
            commands[i] = in.nextInt();
        }
    }

    public void solve(){
        var numbers = new ArrayList<Integer>();
        for(int i = 0; i < k; i++){
            if(commands[i] != 0){
                numbers.add(commands[i]);
            }else{
                numbers.remove(numbers.size()-1);
            }
        }

        int sum = 0;
        for(int n: numbers){
            sum+=n;
        }

        System.out.println(sum);
    }
}
