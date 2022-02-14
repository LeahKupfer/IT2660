package chapter4;

import javax.swing.*;

public class StudentListing {
        private String name;
        private String id;
        private String gpa;
        public StudentListing()
        {
            name = "";
            id = "";
            gpa = "";
        }

        public StudentListing(String n, String i, String g) {
            name = n;
            id = i;
            gpa = g;
        }

        public String toString() {
            return ("Name is " + name +
                    "\nID is " + id +
                    "\nGPA is " + gpa + "\n");
        }

        public StudentListing deepCopy() {
            StudentListing clone = new StudentListing(name, id, gpa);
            return clone;
        }

        public int compareTo(String targetKey) {
            return (name.compareTo(targetKey));
        }

        public void input() {
            name = JOptionPane.showInputDialog("Enter a name");
            id = JOptionPane.showInputDialog("Enter an ID");
            gpa = JOptionPane.showInputDialog("Enter a GPA");
        }
    }
