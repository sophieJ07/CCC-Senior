import java.util.Scanner;

public class S1_2003 {
	Scanner in;
    int current;

    public S1_2003(){
        in = new Scanner(System.in);
        current = 1;
    }

    public void solve(){
        int steps;

        while(true){
            System.out.println("Enter sum of dice:");
            steps = in.nextInt();

            if(steps == 0){
                System.out.println("You Quit!");
                break;
            }

            if(current + steps <= 100) {
                current += steps;
                if (current == 9) current = 34;
                if (current == 40) current = 64;
                if (current == 67) current = 86;
                if (current == 54) current = 19;
                if (current == 90) current = 48;
                if (current == 99) current = 77;
            }else 
            System.out.println("You are now on square " + current);

            if(current == 100){
                System.out.println("You Win!");
                break;
            }
        }
    }
}
