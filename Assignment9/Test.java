/**
 * Leah Kupfer
 */
import java.util.Random;
import java.util.Scanner;
public class Test
{
    public static void main(String[] args)
    {
      Random random = new Random();
      Scanner keyboard = new Scanner(System.in);
      boolean running = true;
      int fail = 0; 
      int n = 1000; 
        Graph g = new Graph(n);

      for(int i = 0; i < n; i++) 
      {
       g.createVert(random.nextInt(100000) + 1);
      }
    
      for(int j = 0; j < n; j++) 
      {
          int q; 
          if(j < (n/10) ) 
          {
            q = (random.nextInt(2) + 1);
          }
          else
          {
              q = (random.nextInt(5) + 1);
          }
          for(int k = 0; k < q; k++)
          {
            int c = random.nextInt(n);
            fail = 0; 
             if(!g.createEdge(j, c ) )
             {
              while(!g.createEdge(j, fail ) && (fail < n) ) 
              {
               fail++;
              }
              if(fail > n) 
              {           
                System.out.println("Graph Creation Error");
                System.exit(1);  
              }
             }
  
          }
       
          
       }

      while(running)
      {  System.out.println("Enter: " + "\n1 to perform a depth-first search: " + 
                            "\n2 To perform a breadth-first search: " + 
                            "\n3 to print all the vertices " + "\n4 to print all the edges/connections" + 
                            "\n5 to verify that all vertices have at least one edge" +
                            "\nOr any other key to exit.");
                            
          switch(keyboard.nextInt() )
          {
            case 1: System.out.println("To perform a depth-first search, enter target vertex");
                    g.dfSearch(keyboard.nextInt() );
             break;
            case 2: System.out.println("To perform a breadth-first search, enter target vertex");
                    g.bfSearch(keyboard.nextInt() ); 
             break;
            case 3:  g.printVertices();
             break;
            case 4:  g.printEdges();
             break;
             case 5: g.edgeTest();
             break;
             default:    
             System.exit(0); 
          }
      
      }

   }
    
}