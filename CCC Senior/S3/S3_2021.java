import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//CCC '21 S3 - Lunch Concert

public class S3_2021 {
    int[] position, speed, distance;
    int friendsNum;
    int min, max;

    public S3_2021() throws FileNotFoundException {
        File file = new File("Data/S3/2021");
        Scanner in = new Scanner(file);

        friendsNum = in.nextInt();
        position = new int[friendsNum];
        speed = new int[friendsNum];
        distance = new int[friendsNum];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for(int i = 0; i < friendsNum; i++){
            position[i] = in.nextInt();
            if(position[i] < min) min = position[i];
            if(position[i] > max) max = position[i];
            speed[i] = in.nextInt();
            distance[i] = in.nextInt();
        }
    }

    public void solve (){
        long minTime = 0;
        int left = min;
        int right = max;
        long time, timeRight, timeLeft;
        int mid = (left + right)/2;

        while(left <= right){

            mid = (left + right)/2 ;

            time = totalTimeCost(mid);
            timeRight = totalTimeCost(mid + 1);
            timeLeft = totalTimeCost(mid - 1);

            if(time <= timeRight && time <= timeLeft){
                minTime = time;
                break;
            }else if (timeRight > timeLeft){
                right = mid - 1;
            }else left = mid + 1;
        }

        System.out.println(minTime);
    }
    
    
    public long friendTimeCost (long p, long w, long d, int c){
        long distance = Math.abs(c - p);
        if(distance > d){
            return (distance - d)*w;
        }
        return 0;
    }

    public long totalTimeCost (int c){
        long total = 0;
        for(int i = 0; i < friendsNum; i++){
            total += friendTimeCost(position[i], speed[i], distance[i], c);
        }
        return total;
    }

}
