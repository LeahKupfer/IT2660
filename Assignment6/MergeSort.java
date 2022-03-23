/**
 * Leah Kupfer
 *
 * 
 */
public class MergeSort
{
    private int[] numBank; 
    private int[] temp;    
    private int left;     
    private int right;   
    private int size;   
  
    public MergeSort(int[] list)
    {
      numBank = list;
      size = list.length;
      left = 0;
      right = size - 1;
      temp = new int[size];
      
    }
  
    public void sort() 
    {
      sort(this.numBank, this.temp, this.left, this.right);
    }
    
    public static void sort(int[] list, int[] temp, int leftIndex, int rightIndex)
    {
        int midIndex, total;
        
        total = rightIndex - leftIndex + 1;
        if(total == 1) //Base Case: A list of no elements or a single element is already sorted
         { 
           return; 
         } 
  
       midIndex = (rightIndex + leftIndex) / 2;

       sort(list, temp, leftIndex, midIndex); 
       sort(list, temp, midIndex + 1, rightIndex);
        merge(list, temp, leftIndex,  midIndex + 1, rightIndex);
        return;
        
    }
    
    public static void merge(int[] list, int[] temp, int leftIndex, int midIndex, int rightIndex)
    { int leftEnd, total, tempIndex;
      leftEnd = midIndex - 1; //The end of the left sublist
      tempIndex = leftIndex;  //Synchronizes the indicies of list and temp
      total = rightIndex - leftIndex + 1; 

      while( (leftIndex <= leftEnd) && (midIndex <= rightIndex) ) //Sorts the list 
      {
          if(list[leftIndex] <= list[midIndex]) 
          {                                     //in the left sublist
              temp[tempIndex] = list[leftIndex];

              tempIndex++;
              leftIndex++;                
          }
          else //If the element is greater than the the rightmost item then it takes the items place in the right sublist
          {    // and shifts the middle index
              temp[tempIndex] = list[midIndex];

              tempIndex++;
              midIndex++;
          }
            
        }
              
      if(leftIndex <= leftEnd)  //Copies the remainder of the left sublist into the temp list if there are still elements present
        {
        while(leftIndex <= leftEnd) 
          {
              temp[tempIndex] = list[leftIndex];
              leftIndex++;
              tempIndex++;
          }
        }
        else 
        {
          while(midIndex <= rightIndex) //Copies the remainder of the right sublist into the temp list
           {
             temp[tempIndex] = list[midIndex];
                
             midIndex++;
             tempIndex++;
           }
         }
     
         for (int i = 0; i < total; i++) //Copies the changes that were made from temp into the list
         {
              list[rightIndex] = temp[rightIndex];
              rightIndex--;
         }
    }

    public void printList() //Prints the contents of the list
    {
      
      if(numBank.length == 0)
      {
        return;
      }
      else
      {
      System.out.println("\nThe contents of numBank are: ");
        for(int i = 0; i < numBank.length; i++)
      {
        System.out.println(numBank[i]);
      }
      System.out.println("~~~~~End of list~~~~~");
      }
      
    }
    
    public void printLength() //Prints the length of the list
    {
        System.out.println("The length of numBank is: " + numBank.length); 
    }
    
}