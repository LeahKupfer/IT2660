package chapter4;

public class LinkedList {
    private Node h;
    public LinkedList()
    {
        h = new Node(); // List header
        /* Node for simplifying the insert and delete algorithms, will not store client data */
        h.one = null;
        h.next = null;
    }

    public boolean insert(StudentListing newStudentListing) {
        Node n = new Node();
        if(n == null) // Out of memory
            return false;
        else
        {
            n.next = h.next; // Inserts the node to the front of the linked list
            h.next = n;
            n.one = newStudentListing.deepCopy(); // Deep copy the data
            return true;
        }
    }
    public StudentListing fetch (String targetKey) {
        Node p = h.next; // Points to the first node in the linked list
        while (p != null && !(p.one.compareTo(targetKey) == 0)) {
            p = p.next;
        }
        if (p != null)
            return p.one.deepCopy();
        else
            return null;
    }
        public boolean delete(String targetKey)
        {
            Node q = h;
            Node p = h.next;
            while (p != null && !(p.one.compareTo(targetKey) == 0))
            {
                q = p;
                p = p.next; // Q trails P in the while loop
            }
            if (p != null) {
                q.next = p.next; // Skip the deleted node
                return true;
            } else
                return false;
        }
        public boolean update(String targetKey, StudentListing newStudentListing)
        {
            if (delete(targetKey) == false)
                return false;
            else if (insert(newStudentListing) == false)
                return false;
            return true;
        }

        public void showAll()
        {
            Node p = h.next;
            while (p != null)
            {
                System.out.println(p.one.toString());
                p = p.next;
            }
        }
        public class Node {
            private StudentListing one;
            private Node next;

            public Node() {
            }
        }
    }