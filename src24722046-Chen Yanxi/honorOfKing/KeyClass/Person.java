package honorOfKing.KeyClass;

public abstract class Person {
    protected String id;
    protected String name;
    
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
  //getter
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
   //abstract method
    public abstract void displayInfo();
}