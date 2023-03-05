import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * public class S1 {
    

}
*/

/*
Problem S2: Boxes
Problem Description
Nowadays, almost any item can be bought and sold on the internet. The problem is shipping. Before an item can be sent,
it must be carefully packaged in a cardboard box to protect it.
While items come in many shapes and sizes, finding a box just the right size can be a problem. If the box is too small,
the item will not fit. If the box is unnecessarily big, shipping cost will be higher, and the item is more likely to
move around inside the box, and it may break.

Cardboard box manufacturers offer a fixed set of standard box sizes. Your task is to find the standard box size with the
smallest volume into which an item will fit.
Each box is a rectangular prism with a given length, width, and height. Each item is also a rect- angular prism with a
given length, width, and height. An item may be rotated by multiples of 90 degrees in any direction before being packed
into a box, but when it is packed, its faces must be parallel to the faces of the box. An item will fit into a box as
long as its dimensions are equal to or less than the dimensions of the box.

Input Specification
The first line of input will contain a single integer n, 0 < n < 1000, the number of different sizes of boxes available.
The next n lines will contain three integers each, giving the length, width, and height of a box. The following line
will contain a single integer m, 0 < m < 1000, the number of items to be packaged. The next m lines will contain three
integers each, giving the length, width, and height of an item. All dimensions will be in millimetres and in the range
from 1 mm to 2000 mm.

Output Specification
Output is to consist of m lines, one for each item in the input. For each item, output a line containing a single
integer, the volume (in mm3) of the smallest box into which the item will fit. The same size of box may be reused for
any number of items. If an item does not fit in any box, print the line: Item does not fit.

Sample Input
3
1 2 3
2 3 4
3 4 5
5
1 1 1
2 2 2
4 3 2
4 3 3
4 4 4

Output for Sample Input
6
24
24
60
Item does not fit.
 */

public class S2_2007 {
    int boxNum, itemNum;
    ArrayList<int[]> boxes;
    ArrayList<int[]> items;
    
    public S2_2007() throws FileNotFoundException{
        var file = new File("Data/S2/2007");
        var in = new Scanner(file);
        boxes = new ArrayList<>();
        items = new ArrayList<>();
        
        boxNum = in.nextInt();
        int[] b = new int[3];
        b[0] = in.nextInt();
    	b[1] = in.nextInt();
    	b[2] = in.nextInt();
    	Arrays.sort(b);
    	boxes.add(b);
    	
    	
    	
        for(int i = 0; i < boxNum-1; i++){
        	b = new int[3];
        	b[0] = in.nextInt();
        	b[1] = in.nextInt();
        	b[2] = in.nextInt();
        	Arrays.sort(b);
        	
        	boolean added = false;
        	for(int j = 0; j < boxes.size(); j++) {
                int[] current = boxes.get(j);
                if(b[0] < current[0]) {
                	boxes.add(j, b);
                	added = true;
                	break;
                }
            }
        	
        	if(!added) boxes.add(b);
        	
        }
        	
        
        
        itemNum = in.nextInt();
        int[] it;
        for(int i = 0; i < itemNum; i++) {
        	it = new int[3];
        	it[0] = in.nextInt();
        	it[1] = in.nextInt();
        	it[2] = in.nextInt();
        	Arrays.sort(it);
        	items.add(it);
        }
        
        
    }
    
    
    public void solve() {
    	
    	for(int[] currentItem:items) {
    		boolean fit = false;
    		for(int[] currentBox:boxes) {
    			if(currentItem[0]<=currentBox[0] && currentItem[1]<=currentBox[1] && currentItem[2]<=currentBox[2]) {
    				System.out.println(currentBox[0] * currentBox[1] * currentBox[2]);
    				fit = true;
    				break;
    			}
    		}
    		if(!fit) System.out.println("Item does not fit.");
    	}
    	
    }
    
}



