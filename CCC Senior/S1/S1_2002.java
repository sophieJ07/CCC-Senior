import java.util.Scanner;

public class S1_2002 {
	int pink, green, red, orange;
    int goal;

    public S1_2002(){
        Scanner in = new Scanner(System.in);
        System.out.println("Cost of PINK tickets:");
        pink = in.nextInt();
        System.out.println("Cost of GREEN tickets:");
        green = in.nextInt();
        System.out.println("Cost of RED tickets:");
        red = in.nextInt();
        System.out.println("Cost of ORANGE tickets:");
        orange = in.nextInt();
        System.out.println("How much must be raised with ticket sales?");
        goal = in.nextInt();
    }

    public void solve(){
        int minticket = Integer.MAX_VALUE;
        int count = 0;

        for(int p = 0; p <= goal/pink; p++){
            for(int g = 0; g <= goal/green; g++){
                for(int r = 0; r <= goal/red; r++){
                    for(int o = 0; o <= goal/orange; o++){
                        if(p * pink + g * green + r * red + o * orange == goal){
                            count++;
                            System.out.println("# of PINK is " + p + "      # of GREEN is " + g + "      # of RED is " + r + "      # of ORANGE is " + o);
                            if(p + g + r + o < minticket) minticket = p + g + r + o;
                        }
                    }
                }
            }
        }
        System.out.println("Total combinations is " + count);
        System.out.println("Minimum number of ticket print is " + minticket);
    }
}
