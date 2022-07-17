import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
//CCC '19 S2 - Pretty Average Primes

public class S2_2019 {
    int n;
    int[] nums;
    int max;

    public S2_2019() throws FileNotFoundException{
    	var file = new File("Data/S2/2019");
        var in = new Scanner(file);
        n = in.nextInt();
        nums = new int[n];
        max = 0;
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
            if (nums[i]>max) max=nums[i];
        }
    }

    public void solve(){
        boolean[] primes = sieve(max*2);
        for(int num:nums){
            int[] pair = findPair(primes, num);
            System.out.println(pair[0] + " "+ pair[1]);
        }
    }

    public int[] findPair(boolean[] isP, int a){
        int[] ret = new int[2];
        for(int i=2;i<a;i++){
            if(isP[i] && isP[2*a-i]) {
                ret[0] = i;
                ret[1] = 2*a-i;
                return ret;
            }
        }
        return null;
    }


    
    public boolean[] sieve(int a){
        boolean[] ret = new boolean[a + 1];
        Arrays.fill(ret, Boolean.TRUE);
        ret[0] = ret[1] = false;

        for(int i=2; i*i<=a; i++){
            if(ret[i]){
                for(int j = i*i; j<=a; j+=i) ret[j]=false;
            }
        }
        return ret;
    }

}
