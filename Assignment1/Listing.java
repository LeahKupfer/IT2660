	 /**
 * Leah Kupfer
 * 
 * 
 */
 import java.util.Scanner; 
 public class Listing
 {
    private String name;
    private int age;
  
    public Listing() 
    {
      name = " "; 
      age = 0;
    }

    public Listing(String newName, int newAge) 
    {
      name = newName;
      age = newAge;
    }
  
    public void input()  
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Type a name: ");
        
        setName(keyboard.nextLine());
        
        System.out.println("Type an age: ");
        
        setAge(keyboard.nextLine());
    }
    
    public void setName(String newName) 
    {
        name = newName;
    }
    
    public void setAge(String newAge) 
    {
       age = Integer.parseInt(newAge); 
    }
    
    public String getName()  
    {
      return name;   
    }
    
    public int getAge()
    {
      return age;
    }
     
    public String toString(int num) 
    {                               
        return "" + num; 
    } 
    
 }