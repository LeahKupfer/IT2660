{
    public static void main(String[] args)
    {
        
    Listing obj1 = new Listing(); 
      obj1.input();
      
      String name1 = obj1.getName(); 
      
      int age1 = obj1.getAge(); 
      
      String ageString1 = obj1.toString(age1); 
      
    System.out.println("Listing 1 - The name is: " + name1 + " and the age is: " + ageString1);  
    
      Listing obj2 = new Listing("Peter", 19); 
     
      String name2 = obj2.getName();  
      int age2 = obj2.getAge();          
    System.out.println("Listing 2 - The name is: " + name2 + " and the age is: " + age2);
      
      obj2.setName("MJ"); 
      
      obj2.setAge("17");        
      
      name2 = obj2.getName();   
      age2 = obj2.getAge();     
    
    System.out.println("Listing 3 - The new name is: " + name2 + " and the age is: " + age2); 
}
}