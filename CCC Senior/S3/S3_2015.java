import java.util.Scanner;

//CCC '15 S3 - Gates

public class S3_2015 {
    Scanner in;
    int numGates, numPlanes;
    Node_plane[] gates;
    int[] planes;

    public S3_2015(){
        in = new Scanner(System.in);
        numGates = in.nextInt();
        numPlanes = in.nextInt();

        gates = new Node_plane[numGates+1];
        for(int i = 0; i < gates.length; i++) gates[i] = new Node_plane();

        planes = new int[numPlanes];
        for(int i = 0; i < numPlanes; i++) planes[i] = in.nextInt();
    }

    public void solve(){
        int max;
        int docked = 0;
        for(int i = 0; i < numPlanes; i++){
            max = planes[i];
            if(!gates[max].occupied){
                docked++;
                gates[max].occupied = true;
                update(max);
            }else{
                if(gates[max].next.index == 0) break;
                else{
                    docked++;
                    gates[gates[max].next.index].occupied = true;
                    update(gates[max].next.index);
                }
            }
        }
        System.out.println(docked);
    }

    public void update(int max){
        if(max > 1 && max < numGates && gates[max-1].occupied && gates[max+1].occupied){
            gates[max+1].next.index = gates[max-1].next.index;
            gates[max].next = gates[max+1].next;
        }else if(max > 1 && gates[max-1].occupied){
            gates[max].next = gates[max-1].next;
        }else if(max < numGates && gates[max+1].occupied){
            gates[max+1].next.index--;
            gates[max].next = gates[max+1].next;
        }else{
            gates[max].next = new PointerNode(max-1);
        }
    }

}

class Node_plane{
    boolean occupied;
    PointerNode next;

    public Node_plane(){
        occupied = false;
        next = null;
    }
}

class PointerNode{
    int index;

    public PointerNode(int i){
        index = i;
    }
}


