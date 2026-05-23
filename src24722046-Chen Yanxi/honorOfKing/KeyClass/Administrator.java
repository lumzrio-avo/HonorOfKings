package honorOfKing.KeyClass;

public class Administrator extends Person {
    private String password;
    
    public Administrator(String id, String name, String password) {
        super(id, name);
        this.password = password;
    }
    
    public boolean authenticate(String password) {
        return this.password.equals(password);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Admin ID: " + id);
        System.out.println("Name: " + name);
    }
}