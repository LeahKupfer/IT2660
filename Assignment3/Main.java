/*  
* Leah Kupfer
 */


public class Main {

    public static void main(String[] args) {
        Stack s = new Stack();
        System.out.print("The Stack is empty: " + s.isEmpty() + "\n");
        s.push(new Listing("bob", "1 Main St", "256"));
        s.push(new Listing("jim", "2 Main St", "648"));
        System.out.print("The Stack is empty: " + s.isEmpty() + "\n");
        s.push(new Listing("abe", "3 Main St", "986"));
        s.showAll();
        System.out.print("The Stack is full: " + s.isFull() + "\n");

        s.push(new Listing("emily", "4 Main St", "658"));
        s.showAll();
        System.out.print("\n" + s.peek() + "\n");
        s.showAll();
        s.reinit();
        System.out.print("The Stack is empty: " + s.isEmpty());
    }
}