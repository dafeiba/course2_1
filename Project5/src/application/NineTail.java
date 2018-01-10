package application;

import java.util.Scanner;

public class NineTail {
  public static void main(String[] args) {
    // Prompt the user to enter nine coins H and T's
    System.out.print("Enter an initial nine coin H's and T's: ");
    Scanner input = new Scanner(System.in);
    String s = input.nextLine(); 
    char[] initialNode = s.toCharArray();

    FarmerCrossRiver model = new FarmerCrossRiver();
    java.util.List<Integer> path =
      model.getShortestPath(FarmerCrossRiver.getIndex(initialNode));

    System.out.println("The steps to flip the coins are ");
   
    
    for (int i = 0; i < path.size(); i++)
      FarmerCrossRiver.printNode(
        FarmerCrossRiver.getNode(path.get(i).intValue()));   
    
  }
}
