/**
 * Leah Kupfer
 */
import java.util.Scanner;
public class Test
{
  public static void main(String[] args)
  {
      Scanner keyboard = new Scanner(System.in); 
      BinaryTree obj1 = new BinaryTree();
       
        System.out.println("Enter Any Key To Begin:");
        keyboard.nextLine();
    while(obj1.running)
      {
      System.out.println(
      "\nEnter:\n1 to fetch and output information for a specific student"
            + "\n2 to insert new information" 
            + "\n3 to delete information" 
            + "\n4 to update a listing" 
            + "\n5 to output all listings in descending order"
            + "\n6 or any other key to exit");
                            
      obj1.prompt(keyboard.nextLine() );   
    }    
        
  }
}