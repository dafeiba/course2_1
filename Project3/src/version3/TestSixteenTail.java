package version3;

import java.util.Scanner;

public class TestSixteenTail {

	  public static void main(String[] args) {
		    // 提示用户输入九个硬币H和T的
		    System.out.print("Enter an initial nine coin H's and T's: ");
		    Scanner input = new Scanner(System.in);
		    String s = input.nextLine(); 
		    char[] initialNode = s.toCharArray();

		    SixteenTailModel model = new SixteenTailModel();
		    java.util.List<Integer> path =
		      model.getShortestPath(SixteenTailModel.getIndex(initialNode));

		    System.out.println("The steps to flip the coins are ");
		    for (int i = 0; i < path.size(); i++)
		    	SixteenTailModel.printNode(
		    			SixteenTailModel.getNode(path.get(i).intValue()));    
		  }  
}
