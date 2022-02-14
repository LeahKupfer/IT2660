package chapter4;

public class MainLinkedList {
    public static void main(String[] args)
    {
        LinkedList test = new LinkedList();
        StudentListing one= new StudentListing("Adam", "4343", "3.0");
        StudentListing two = new StudentListing("Carla", "5656", "3.5");
        StudentListing three = new StudentListing("Frank", "9898", "2.5");
        // Test of the insert method
        test.insert(one);
        test.insert(two);
        test.insert(three);
        test.showAll();
        // Test of the fetch method
        three = test.fetch("Frank");
        System.out.println(three.toString());
        // Test of the delete method
        test.delete("Carla");
        test.showAll();
        // Test of the update method
        test.update("Frank", two);
        test.showAll();
        System.exit(0);
    }
}