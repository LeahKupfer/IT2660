/* 
* Leah Kupfer
 */

public class Stack {
    private Listing[] data;
    private int top;
    private int size;

   
    public void reinit() { top = -1; }

    
    public boolean isEmpty() {
        if(top == -1) {
            return true;
        }
        else {
            return false;
        }
    }

    
    public boolean isFull() {
        if(top == size - 1) {
            return true;
        }
        else {
            return false;
        }
    }


    public Listing peek() {
        if(top == -1) {
            return null;
        }
        else {
            return data[top];
        }
    }

    public void push(Listing newNode) {
        if(top == size - 1) {
            Listing[] newData = new Listing[top + 1];
            for(int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
            size++;
        }
        top++;
        data[top] = newNode.deepCopy();
    }

    public Listing pop() {
        int topLocation;
        if(top == -1) {
            return null;
        }
        else {
            topLocation = top;
            top--;
            return data[topLocation];
        }
    }

    public void showAll() {
        for(int i = top; i >= 0; i--) {
            System.out.print(data[i].toString());
        }
    }

    public Stack() {
        top = -1;
        size = 100;
        data = new Listing[100];
    }

    public Stack(int n) {
        top = -1;
        size = n;
        data = new Listing[n];
    }
}