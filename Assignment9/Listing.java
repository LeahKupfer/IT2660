/**
 * Leah Kupfer
 */
public class Listing
{
    private int value; 
    private int connections; 
    private boolean pushed; 
    public Listing(int x)
    {
       value = x; 
       pushed = false;
       connections = 0;
    }

   public Listing deepCopy()
    {
      return new Listing(this.value);
    }
    
    public String toString()
    {
      return "" + this.value;
    }
    
    public int getValue()
    {
        return this.value;
    }
    
    public int getConnections()
    {
      return this.connections;
    }
    
    public void addConnection()
    {
       this.connections++; 
    }
    
    public boolean getPushed()
    {
      return this.pushed;
    }
    
    public void setPushed(boolean state) 
    {
       this.pushed = state;
    }

}

