/**
 *Leah Kupfer
 */
import java.util.Random;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class Graph
{
    Listing[] vertices;
    Node[] edges; 
    private int index; 
    private int size;
    private int popped;
    public Graph(int n) 
    {
      vertices = new Listing[n]; 
      edges = new Node[n];
      for(int i = 0; i < n; i++) 
      {
        edges[i] = new Node();
      }
      index = 0; 
      size = n; 
    }
    
       public class Node 
     {               
       private Node nextHop;
       private int id; 
       private int weight; 
 
    
       public Node() 
       {
         this.id = -1;
         this.weight = -1;
         this.nextHop = null;
      
       }
       public Node(int e) 
       {
         this.id = e;
         this.nextHop = null;
    
       }
       public int getID()
       {
         return this.id;
       }
       public int getWeight()
       {
          return this.weight; 
       }
       
     }

     public void createVert(int value) 
     {
         
         if(index == size)
         {
        
             return;   
         }
         else 
         {
            vertices[index] = new Listing(value);
            index++; 
         }
         
                 
         
     }
     
     public boolean createEdge(int v1, int v2)
     {
         if(index == 0) 
          {
     
             return false;
          }
          else if( ((v1 >= size) || (v1 < 0)) || ((v2 >= size) || (v2 < 0)) ||(v1 == v2) ||  
                   (vertices[v1] == null || vertices[v2] == null)              ) 
              {
                
                  return false;
              }
          else if(index == 1 || ( (vertices[v1].getConnections() == 5) || vertices[v2].getConnections() == 5) )
          {                                                                                                     
        
             return false;
          }
          else
          {

                 Node temp = edges[v1];
                 while(temp.nextHop != null) 
                 {
                     if(v2 == temp.nextHop.getID() )
                     {
               
                        return false;
                     }
                     else
                     {
                     
                         temp = temp.nextHop;
                     }
                 }
                 temp.nextHop = new Node(v2); 
                 vertices[v1].addConnection();
                 createEdge(v2, v1, true); 
     
                  return true;
            
      
                 }

            }
                
     private boolean createEdge(int v1, int v2, boolean alreadyConnected) 
     {                                                                    
         if(alreadyConnected  == false)
         {
          return false;   
         }
         else
         {
            Node temp = edges[v1];
                 while(temp.nextHop != null) 
                 {
                     if(v2 == temp.nextHop.getID() ) 
                     {
          
                        return false;
                     }
                     else
                     {
       
                         temp = temp.nextHop;
                     }
                 }
                 temp.nextHop = new Node(v2); 
                 vertices[v1].addConnection();
                 temp.nextHop.weight = Math.abs( (v1 % size) - (v2 % size) );

                 return true;   
         }
       
     }
            
            
     public void printVertices() 
     {
         if(index == 0)
         {
             System.out.println("The Graph Is Empty!!");
         }
         else
         {
             System.out.println("The graph has: " + index + " vertices which are: ");
             for( int i = 0; i < index; i++)
             {
                System.out.println("Vertex: " + i + " value: " + vertices[i].toString() );
          
             }
         }
     }
     
    public void printEdges()
    {
      
        if(index == 0)
         {
             System.out.println("The Graph Is Empty!!");
         }
         else
         {
            for( int i = 0; i < index; i++)
             {
                 if(edges[i].id == -1 && edges[i].nextHop == null) 
                 {
                       System.out.println("Vertex: " + i + " Has No Edges!"); 
                 }
                 else{
                  System.out.println("The Edges Of Vertex: " + i + " Are: ");
                    Node j = edges[i].nextHop;
                   while(j != null)
                  {
                      System.out.println(j.getID() );
                      j = j.nextHop;
                  }
                     }
             }
         }
    }
     

    
    public boolean dfSearch(int targetVert) 
    {
        Random r = new Random();
        int choice = r.nextInt(size);
        int vert = -1; 
        Stack<Integer> stack = new Stack(); 
        
        for(int l = 0; l < index; l++) 
        {
           vertices[l].setPushed(false);
        }
        popped = 0;
        
        stack.push(choice); 
        vertices[choice].setPushed(true);
        System.out.println("Depth-First Search beginning with vertex: " + choice);
        while(!stack.isEmpty() ) 
          {
             vert = stack.pop(); 
             popped++;
             System.out.println("Vertex: " + vert + " Value: " + vertices[vert].getValue() );
      
             if(vert == targetVert ) 
             {
               System.out.println("Successfully located vertex: " + vert
                                   + " in " + popped + " searches!"     );
               System.out.println("The value of vertex: " + vert + " is: " + vertices[vert].getValue() );
               return true;
             }
             for(int edge = 0; edge < size; edge++)
                {
                  Node j = edges[edge];
                    while(j.nextHop != null)
                  {
                      if( !vertices[j.nextHop.getID() ].getPushed() ) 
                      {
                         stack.push(j.nextHop.getID() );
                         vertices[j.nextHop.getID() ].setPushed(true);
                      }
                      j = j.nextHop;
                  } 

                 } 
          } 
         
          System.out.println("Vertex: " + targetVert + " not found in " + popped + " searches!" );
          return false; 

    }
    
    public boolean bfSearch(int targetVert)
    {
        Random r = new Random();
        int choice = r.nextInt(size);
        int vert = -1;
        Queue<Integer> queue = new LinkedList<Integer>(); 
        
        for(int l = 0; l < index; l++) 
        {
           vertices[l].setPushed(false);
        }
        popped = 0;
        
        queue.add(choice); 
        vertices[choice].setPushed(true);
        System.out.println("Breadth-First Search beginning with vertex: " + choice);
        while(!queue.isEmpty() ) 
          {
             vert = queue.poll(); 
             ++popped;
             System.out.println("Vertex: " + vert + " Value: " + vertices[vert].getValue() );
          
             if(vert == targetVert )
             {
               System.out.println("Successfully located vertex: " + vert
                                   + " in " + popped + " searches!"     );
               System.out.println("The value of vertex: " + vert + " is: " + vertices[vert].getValue() );
               return true;
             }
             for(int edge = 0; edge < size; edge++)
                {
                  Node j = edges[edge];
                    while(j.nextHop != null)
                  {
                      if( !vertices[j.nextHop.getID() ].getPushed() ) 
                      {
                         queue.add(j.nextHop.getID() );
                         vertices[j.nextHop.getID() ].setPushed(true);
                      }
                      j = j.nextHop;
                  } 

                 } 
          } 
         
          System.out.println("Vertex: " + targetVert + " not found in " + popped + " searches!" );
          return false; 
   
    
    }

    
    public boolean edgeTest()
    {
         for(int i = 0; i < size; i++)
        {
              if( (vertices[i].getConnections() == 0 ) || (vertices[i].getConnections() < 1) )
              {
                System.out.println("NO CONNECTION FOUND!!");
                System.out.println("Vertex: " + i + " " + vertices[i]);
                return false;
              }

        }
        System.out.println("All Vertices Have An Edge");
        return true;
    }
}