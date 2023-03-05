import java.util.Scanner;

//CCC '02 S3 - Blindfold

/*
Rose and Colin are playing a game in their backyard. Since the backyard is rectangular we can think of it as a grid with
r rows and c columns. Rose and Colin place obstacles on some of the squares. The game is played as follows:

Colin covers his eyes with a blindfold then Rose carries him to some grid square in the backyard. She sets him down so
that he is facing north, south, east or west. Colin does not know this initial position or direction.
Rose then instructs Colin to make a series of m moves through the backyard.
Each move is one of:
F - moves forward one grid square in the direction that he is facing, or
L - turns 90 degrees counter-clockwise, remaining on the same square, or
R - turns 90 degrees clockwise, remaining on the same square.

After making these moves, Colin is standing at some final position. He must now figure out where he is standing. You
will help him by writing a program to determine all possible final positions. Assume that Colin's initial position,
final position, and all intermediate positions lie within the backyard but never in a square that contains an obstacle.
You may also assume that Colin is always facing a direction that is parallel to the sides of the backyard (north, south,
east, or west).

Your program should output the backyard grid, indicating all possible final positions with the * character.

Sample Input 1 (Input file : blind.in)
2
4
....
.XX.
3 F R F
Output for Sample Input 1 (Output file : blind.out)
.*..
.XX*

Sample Input 2
5
5
.....
.X.X.
.....
.XXX.
.....
6 F F F F R F
Output for Sample Input 2
.*...
*X.X*
.....
*XXX*
...*.

Sample Input 3
5
5
.....
.X.X.
.....
.X.X.
.....
16 R F F L L L F F L L L F F R F F
Output for Sample Input 3
*.*.*
.X.X.
*.*.*
.X.X.
*.*.*

Sample Input 4
1
64
................................................................
50 F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F
Output for Sample Input 4
**************....................................**************
*/

class GridNode {
    boolean isObstacle;
    boolean canArrive; 
    GridNode[] directions;
    

    public GridNode(){
        isObstacle = false;
        canArrive = false; 
        directions = new GridNode[4];
    }

    public GridNode(boolean o){
        isObstacle = o;
        directions = new GridNode[4];
    }

    
    public String toString(){
        StringBuilder ret = new StringBuilder();
        if(isObstacle) ret.append("X");
        else ret.append(".");

        ret.append("(");
        for(int i = 0; i < 4; i++){
            if(directions[i] == null) ret.append("n");
            else{
                if(directions[i].isObstacle) ret.append("X");
                else ret.append(".");
            }
        }
        ret.append(")");

        return ret.toString();
    }
    
}

public class S3_2002 {
    GridNode[][] grid;
    int rowNum, colNum, insLength;
    char[] instructions;

    public S3_2002(){
        Scanner in = new Scanner(System.in);
        rowNum = in.nextInt();
        colNum = in.nextInt();
        grid = new GridNode[rowNum][colNum];

        String line;
        line = in.nextLine();
        for(int i = 0; i < rowNum; i++){
            line = in.nextLine();
            for(int j = 0; j < colNum; j++){
                grid[i][j] = new GridNode(line.charAt(j) == 'X');
            }
        }

        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(i>0) grid[i][j].directions[0] = grid[i-1][j];
                if(j<colNum-1) grid[i][j].directions[1] = grid[i][j+1];
                if(i<rowNum-1) grid[i][j].directions[2] = grid[i+1][j];
                if(j>0) grid[i][j].directions[3] = grid[i][j-1];
            
            }
          
        }
        
        String ins = in.nextLine();
        String[] s = ins.split(" ");
        insLength = Integer.parseInt(s[0]);
        instructions = new char[insLength];
        for(int k = 0; k < insLength; k++){
            instructions[k] = s[k+1].charAt(0);
        }
        
    }
    
    public void solve(){
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(!grid[i][j].isObstacle){
                    move(grid[i][j], 0);
                    move(grid[i][j], 1);
                    move(grid[i][j], 2);
                    move(grid[i][j], 3);
                }
            }
        }
        
        for(int i = 0; i < rowNum; i++) {
        	for(int j = 0; j < colNum; j++) {
        		if(grid[i][j].canArrive) System.out.print('*');
        		else if (grid[i][j].isObstacle) System.out.print('X');
        		else System.out.print('.');
        	}
        	System.out.println();
        }
    }
    
    public void move(GridNode start, int in){
        int index = in;
        GridNode current = start; 
        boolean arrived = true;
        
        for(int i = 0; i < insLength; i++) {
        	if(instructions[i] == 'F') {
        		current = current.directions[index]; 
        		if(current == null || current.isObstacle) {
        			arrived = false; 
        			break;
        		}
        	}else if(instructions[i] == 'L'){
        		index--; 
        		if(index < 0) index = 3; 
        		
        	}else {
        		index++;
        		if(index > 3) index = 0; 
        	}
        }
      
        if(arrived) current.canArrive = true; 
        
       
        
    }

    
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j <colNum; j++){
                ret.append(grid[i][j].toString());
            }
            ret.append("\n");
        }
        return ret.toString();
    }
    
}


