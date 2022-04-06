/**
 * Leah Kupfer
 */
import java.util.Scanner; 
import java.util.StringTokenizer;
public class BinaryTree
{
    Node root; 
    public boolean running; 
    public BinaryTree()
    {
      root = null; 
      running = true; 
    }
    
     public class Node  
     {                
       private Listing node;    
       private Node rightList; 
       private Node leftList;  
       public Node() 
       {
       }
     }
    
     public class Wrapper 
     {                    
       Node nodeRef = null;
      
       public Wrapper()
       { 
       }
       
       public Node getNode()
       {
         return nodeRef;
       }
       
       public void setNode(Node n)
       {
        nodeRef = n;
       }
       
     }
    
    public void prompt(String choice)
    {
        Scanner keyboard = new Scanner(System.in); 
        String delimeter = "|";
    
       switch(choice)
        {
          case "1": 
             System.out.println("Enter a student's full name to fetch their information: ");
             System.out.println( fetch(keyboard.nextLine() ).toString() ); 
          break;
          case "2": 
             System.out.println("Enter a student's full name and gpa separated by '|': ");
             StringTokenizer t = new StringTokenizer(keyboard.nextLine(), "|");
            try{
                System.out.println("Information Inserted? " + insert(new Listing(t.nextToken(), Double.parseDouble(t.nextToken() )) ) );
               }
            catch(java.util.NoSuchElementException e)
              {
                 System.out.println("Invalid Argument(s) Entered!");
              }
            catch(java.lang.NumberFormatException e)
              {
                 System.out.println("Invalid Number(s) Entered!");
              }
          break;
          case "3": //Delete
            System.out.println("Enter a student's full name to delete their information: ");
            System.out.println("Information Deleted? " + delete(keyboard.nextLine() ) );
          break;
          case "4": //Update
            System.out.println("Enter the full name of the student that you wish to update: ");
            String s = keyboard.nextLine();
            System.out.println("Now, enter the new name and gpa information, separated by '|', to update the listing: ");
            StringTokenizer u = new StringTokenizer(keyboard.nextLine(), "|");
             try{
                    System.out.println("Listing Updated? " + update(s, new Listing(u.nextToken(), Double.parseDouble(u.nextToken() ))) );
                }
            catch(java.util.NoSuchElementException e)
                {
                   System.out.println("Invalid Argument(s) Entered!");
                 }
            catch(java.lang.NumberFormatException e)
                {
                   System.out.println("Invalid Number(s) Entered!");
                }
          break;
          case "5": 
             System.out.println("Outputting all listing information: ");
             output();
          break;
          default: 
             System.out.println("Are You Sure You Want To Exit? "
                               +"Enter 'y' or 'Y' To Exit The Program Or Enter Any Other Key To Continue:");
                               String i = keyboard.nextLine();
               if(i.equalsIgnoreCase("y") ) 
                 {
                    System.out.println("Exiting Program");
                    running = false;
                    System.exit(0);               
                 }
              else
                 {
                   break;   
                 }

         }

    }
      
    public Listing fetch(String target) 
    {
        Wrapper p = new Wrapper();
        Wrapper c = new Wrapper();

        if(findNode(target, p, c) == true && root != null) 
        {
            System.out.println("Fetched: " + target);
            return c.getNode().node.deepCopy();
        }
        else
        {
            System.out.println("Unable To Fetch Target Listing: '" + target + "' Not Found");
            return new Listing("", 0.0);
     
        }
        
    }
    
    public boolean insert(Listing l) 
    {
        Wrapper p = new Wrapper();
        Wrapper c = new Wrapper();
        Node n = new Node();
     
        if(n == null) //Out of memory
        {
           return false; 
        }
        else if(findNode(l.getKey(), p, c) == true)
        {
          System.out.println("A Listing With That Name Already Exists!");
          return false; 
        }
        else
        {
          n.node = l.deepCopy();
          n.leftList = null;
          n.rightList = null;
             if(root == null)
             {
               root = n;
             }
             else 
             {  
                findNode(l.getKey(), p, c); 
                if(l.getKey().compareTo(p.getNode().node.getKey() ) < 0)
                {
                    p.getNode().leftList = n; 
                }
                else
                {
                    p.getNode().rightList = n; 
                }
                
             }
            return true;
        }
       
        
    }
    
        public boolean delete(String target) 
       {
          Wrapper p = new Wrapper();
          Wrapper c = new Wrapper();
          Node big;
          Node nextBig; 

        if(findNode(target, p, c) == false) 
        {
          return false; 
        }
        else 
        {
            
            if(c.getNode().leftList == null && c.getNode().rightList == null)
             {
              if(p.getNode().leftList == c.getNode() ) 
               {
                   if(c.getNode() == root)
                   {
                    root = null;
                   }
                   p.getNode().leftList = null;
               }
              else 
               {
                     if(c.getNode() == root)
                   {
                    root = null;
                   }
                   p.getNode().rightList = null;
             }
            
             }//end case 1 
        
         else if( c.getNode().leftList == null || c.getNode().rightList == null) 
            {
              
              if(p.getNode().leftList == c.getNode() ) 
              {
               
                  if(c.getNode().leftList != null ) 
                 {
                              if(c.getNode() == root)
                        {
                         root = c.getNode().leftList;
                        }
                        p.getNode().leftList = c.getNode().leftList; 
                 }
                  else 
                 {
                        if(c.getNode() == root)
                        {
                         root = c.getNode().rightList;
                        }
                        p.getNode().leftList = c.getNode().rightList; 
                 }
              
              }
              
              else 
               {
                 
                if(c.getNode().leftList != null )
                 {
                        
                     if(c.getNode() == root)
                       {
                         root = c.getNode().leftList;
                       }
                      p.getNode().rightList = c.getNode().leftList; 
                 }
                else 
                 {
                        
                    if(c.getNode() == root)
                      {
                         root = c.getNode().rightList;
                      }
                    p.getNode().rightList = c.getNode().rightList; 
                 }
                
               }
                
            }  
            else 
             {
               nextBig = c.getNode().leftList;
               big = nextBig.rightList; 
               if(big != null)
               {
                 while(big.rightList != null)
                 {
                  nextBig = big;
                  big = big.rightList;
                 }
                 c.getNode().node = big.node; 
                 nextBig.rightList = big.leftList;
                
               }
               else 
               {
                  nextBig.rightList = c.getNode().rightList;
                  if(p.getNode().leftList == c.getNode() )
                  {
                        if(c.getNode() == root)
                        {
                         root = nextBig;
                        }
                        p.getNode().leftList = nextBig; 
                  }
                  else 
                  {
                         if(c.getNode() == root)
                        {
                         root = nextBig;
                        }
                        p.getNode().rightList = nextBig; 
                  }
                 
               }
              
              
            }
            
            return true;
        }
                 
    }
    
    public boolean update(String target, Listing l) 
    {
       if(delete(target) == false)
        {
           return false; 
        }
        else if(insert(l) == false)
        {
           return false; 
        }
        return true; 
   
    }
     
    public void output() 
    {
 
      if(root == null)
      {
        return;
      }
        if(root.leftList != null)
      {
        output(root.leftList);
        
      }
      System.out.println(root.node.toString() ); 
      if(root.rightList !=null) 
      {
         output(root.rightList);
        }

    }
    
    private void output(Node r) 
    {
       
      if(root == null)
      {
        return;
      }
      if(r.leftList != null)
      {
         output(r.leftList);
        
      }
      System.out.println(r.node.toString() );
      if(r.rightList != null)
      {
        output(r.rightList);
      }
    }
   
     private boolean findNode(String target, Wrapper parent, Wrapper child) 
     {
        parent.setNode(this.root); 
        child.setNode(this.root);
        
        if(root == null) 
        { 
             return false;
        }
        else
        {
          
            while(child.getNode() != null)
          {    
            if(child.getNode().node.compareToIgnoreCase(target) == 0 ) 
            {
                 return true;
            }
            else
            {  
              parent.setNode(child.getNode() );         
              if(target.compareToIgnoreCase( child.getNode().node.getKey() ) < 0) 
              {
                 child.setNode(child.getNode().leftList);
              }
              else 
              {
               child.setNode(child.getNode().rightList);
              }
              
            }
          }
          return false; 
        }
      }                                            

  }