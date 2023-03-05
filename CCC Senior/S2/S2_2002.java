import java.util.Scanner;

public class S2_2002 {
    int n, d;

    public S2_2002(){
        Scanner in = new Scanner(System.in);
        System.out.println("Numerator");
        n = in.nextInt();
        System.out.println("Denominator");
        d = in.nextInt();
    }

    public void solve(){
        int x = gcd(n, d);
        n /= x;
        d /= x;


        if(d == 1) System.out.println(n);
        else if(n > d){
            int whole = n/d;
            System.out.println(whole + " " + (n - whole*d) + "/" + d);
        } else if (n == 0){
            System.out.println(0);
        } else {
            System.out.println(n + "/" + d);
        }
    }

    public int gcd(int a, int b){
        int ret = 1;
        for(int i = 1; i <= a && i <= b; i++){
            if(a % i == 0 && b % i == 0){
                ret = i;
            }
        }
        return ret;
    }
}
