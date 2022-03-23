/**
 * Leah Kupfer
 * 
 *
 */
import java.util.Random;
public class test
{
    public static void main(String[] args)
    { 
        int[] list = new int[100]; 
        int[] temp = new int[100];
        int[] list2 = new int[100]; 
        Random random = new Random();
        
        //Loops that will fill the arrays with random numbers from 0 to 285
         for(int i = 0; i < 100; i++) 
       {
         list[i] = random.nextInt(285);   
       }
       for(int i = 0; i < 100; i++)
       {
         list2[i] = random.nextInt(275);   
       }

        MergeSort m = new MergeSort(list); 
        System.out.println("Printing the unsorted contents of list1: ");
        m.printLength(); 
        m.printList();  
        m.sort(list, temp, 0, 99);
        
        m.printLength();
       System.out.println("After sorting, list1's contents are: " );
        m.printList(); 
        
        MergeSort m2 = new MergeSort(list2); 
        m2.printLength();
       
        System.out.println("Printing the unsorted contents of list2: ");
        m2.printList();
        m2.sort();
        
        m2.printLength();
        System.out.println("After sorting, list2's contents are: " );
        m2.printList(); 
       
    }

}