import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

//CCC '17 S1 - Sum Game

public class S1_2017{
	int days; 
    int[] swifts; 
    int[] semaphores; 

    public S1_2017() throws FileNotFoundException {
        var file = new File("Data/S1/2017");
        Scanner in = new Scanner(file);
        days = in.nextInt();
        swifts = new int[days];
        semaphores = new int[days];

        for(int i = 0; i < days; i++){
            swifts[i] = in.nextInt();
        }

        for(int i = 0; i < days; i++){
            semaphores[i] = in.nextInt();
        }
    }

    public void solve(){
        int result = 0;
        int swiftsSum = 0;
        int semaphoresSum = 0;

        for(int i = 0; i < days; i++){
            swiftsSum += swifts[i];
            semaphoresSum += semaphores[i];

            if(swiftsSum == semaphoresSum) result = i+1;
        }

        System.out.println(result);
    }
}

