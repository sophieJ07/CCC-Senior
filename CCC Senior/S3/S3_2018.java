import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//CCC '18 S3 - RoboThieves

public class S3_2018 {
	public S3_2018() throws FileNotFoundException{
		Graph x  = new Graph();
		x.solve();
	}
	
}

class Node_robot{
    int value;
    char property;
    Node_robot up, down, right, left;
    int r, c;
    boolean visited;

    public Node_robot(char p, int row, int column){
        property = p;
        value = Integer.MAX_VALUE;
        visited = false;

        up = null;
        down = null;
        right = null;
        left = null;

        r = row;
        c = column;

    }

    public String toString(){

        var ret = new StringBuilder();
        ret.append(String.valueOf(property));
        if(left != null) ret.append("L");


        if(right != null) ret.append("R");

        if(up != null) ret.append("U");
        if(down != null) ret.append("D");


        return ret.toString();
    }
}

class Graph{
    Node_robot[][] map;
    int row, column;
    ArrayList<Node_robot> cameras;
    Node_robot start;

    public Graph() throws FileNotFoundException {
        File file = new File("Data/CCC_2018/S3");
        Scanner in = new Scanner(file);
        row = in.nextInt();
        column = in.nextInt();
        map = new Node_robot[row][column];
        cameras = new ArrayList<>();

        String line = in.nextLine();
        char ch;
        for(int i = 0; i < row; i++){
            line = in.nextLine();
            for(int j = 0; j < column; j++){
                ch = line.charAt(j);
                Node_robot n = new Node_robot(ch, i, j);
                if (ch == 'C') cameras.add(n);
                if(ch == 'S') start = n;
                map[i][j] = n;
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(i > 0 && (map[i][j].property == '.' || map[i][j].property == 'U' || map[i][j].property == 'S')){
                    map[i][j].up = map[i-1][j];
                }

                if(i < row - 1 && (map[i][j].property == '.' || map[i][j].property == 'D' || map[i][j].property == 'S')){
                    map[i][j].down = map[i+1][j];
                }

                if(j > 0 && (map[i][j].property == '.' || map[i][j].property == 'L' || map[i][j].property == 'S')){
                    map[i][j].left = map[i][j-1];
                }

                if(j < column-1 && (map[i][j].property == '.' || map[i][j].property == 'R' || map[i][j].property == 'S')){
                    map[i][j].right = map[i][j+1];
                }

            }
            
        }
        cameraView();
       
    }
    
    public void solve() {
        ArrayList<Node_robot> remainingNodes = new ArrayList<>();
        start.value = 0;
        remainingNodes.add(start);
        dijkstra(remainingNodes);
        printValues();
    }

    public String toString(){
        var ret = new StringBuilder();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if (map[i][j] == null) ret.append('X');
                else ret.append(map[i][j].toString());
                ret.append(" ");
            }
            ret.append('\n');
        }
        return ret.toString();
    }

    public void cameraView(){
        Node_robot cam;
        int row, col;
        for(int i = 0; i < cameras.size(); i++){
            cam = cameras.get(i);
            row = cam.r;
            col = cam.c;

            System.out.println(row + " c " + col);

            for (var r = row - 1; map[r][col].property != 'W'; r--){
                if(map[r][col].property == '.'){
                    map[r][col] = null;
                }
            }

            for (var r = row + 1; map[r][col].property != 'W'; r++){
                if(map[r][col].property == '.'){
                    map[r][col] = null;
                }
            }

            for (var c = col - 1; map[row][c].property != 'W'; c--){
                if(map[row][c].property == '.'){
                    map[row][c] = null;
                }
            }

            for (var c = col + 1; map[row][c].property != 'W'; c++){
                if(map[row][c].property == '.'){
                    map[row][c] = null;
                }
            }

        }
    }
    
    public void dijkstra(ArrayList<Node_robot> remainingNodes){
        Node_robot current;
        while(!remainingNodes.isEmpty()){
            current = leastValue(remainingNodes);
            if(current.up != null){
                if(current.up.property == 'D'){
                    current.up = null;
                }else if(current.up.property == '.') {
                    current.up.value = Math.min(current.up.value, current.value + 1);
                    remainingNodes.add(current.up);
                }else if(current.up.property != 'W'){
                    current.up.value = Math.min(current.up.value, current.value);
                    remainingNodes.add(current.up);
                }
            }

            if(current.down != null){
                if(current.down.property == 'U'){
                    current.down = null;
                }else if(current.down.property == '.') {
                    current.down.value = Math.min(current.down.value, current.value + 1);
                    remainingNodes.add(current.down);
                }else if(current.down.property != 'W'){
                    current.down.value = Math.min(current.down.value, current.value);
                    remainingNodes.add(current.down);
                }
            }

            if(current.right != null){
                if(current.right.property == 'L'){
                    current.right = null;
                }else if(current.right.property == '.') {
                    current.right.value = Math.min(current.right.value, current.value + 1);
                    remainingNodes.add(current.right);
                }else if(current.right.property != 'W'){
                    current.right.value = Math.min(current.right.value, current.value);
                    remainingNodes.add(current.right);
                }
            }

            if(current.left != null){
                if(current.left.property == 'R'){
                    current.left = null;
                }else if(current.left.property == '.') {
                    current.left.value = Math.min(current.left.value, current.value + 1);
                    remainingNodes.add(current.left);
                }else if(current.left.property != 'W'){
                    current.left.value = Math.min(current.left.value, current.value);
                    remainingNodes.add(current.left);
                }
            }

            

        }

    }
    
    public Node_robot leastValue(ArrayList<Node_robot> remainingNodes) {
    	
    	Node_robot ret = remainingNodes.get(0);
    	
    	for(int i = 1; i < remainingNodes.size(); i++) {
    		if(remainingNodes.get(i).value < ret.value) {
    			ret = remainingNodes.get(i);
    		}
    	}
    	return ret; 
    	
    }

    public void printValues() {
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < column; j++) {
    			if(map[i][j].property == '.') {
    				if(map[i][j].value == Integer.MAX_VALUE) System.out.println(-1);
    				else System.out.println(map[i][j].value);
    			}
    		}
    	}
    }

}
