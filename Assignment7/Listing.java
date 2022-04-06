/**
 * Leah Kupfer
 */
public class Listing
{
    private String name;
    private double gpa;
    private int id;

    
    private Listing(String n, double g ,int i)
    {
        name = n;
        gpa = g;
        id = i;
    }

    public Listing(String n, double g)
    {
      name = n;
      gpa = g;
      id = preprocess(name); 
    }
    
    
    public String getKey() 
    {
     return this.name; 
    }
    
    public void setKey(String newKey)
    {
      this.name = newKey;
    }
    
    public void setID(int i) 
    {
     id = i; 
    }
    
    public String toString()
    {
     return ("Name: " + this.name + " GPA: " + this.gpa + " ID: " + id);  
    }
    
    public Listing deepCopy()
    {
      return new Listing(this.name, this.gpa, this.id);
    }
    
    public int compareToIgnoreCase(String target) 
    {
        return (name.compareToIgnoreCase(target) );
    }

    public static int preprocess(String key) 
    {                              
       int pseudoKey = 0;
       int n =1;
       int cn = 0;
       char c[] = key.toCharArray();
       int group = 0;
       while(cn < key.length() )
       {
        group = group << 8; 
        group = group + c[cn];
        cn++;
        if(n == 4 || cn == key.length() )
        {
        pseudoKey = pseudoKey + group;
        n = 0;
        group = 0;
        }
        n++;
        
       }
       
       return Math.abs(pseudoKey); 
    }
    
}