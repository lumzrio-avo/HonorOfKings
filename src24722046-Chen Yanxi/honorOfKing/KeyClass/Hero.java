package honorOfKing.KeyClass;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String id;
    private String name;
    private String type;
    private int baseAttack;//basic attack power
    private int baseDefense;//basic defense power
    private int baseHealth;//basic health value
    private List<Equipment> equipments;//equip list
    private List<Player> owners;//players own the hero
    
    public Hero(String id, String name, String type, int baseAttack, int baseDefense, int baseHealth) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseHealth = baseHealth;
        this.equipments = new ArrayList<>();
        this.owners = new ArrayList<>();
    }
    
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
        equipment.addHero(this);
    }
    
    public void addOwner(Player player) {
        owners.add(player);
        player.addHero(this);
    }
    //getter
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public int getBaseAttack() {
        return baseAttack;
    }
    
    public int getBaseDefense() {
        return baseDefense;
    }
    
    public int getBaseHealth() {
        return baseHealth;
    }
    
    public List<Equipment> getEquipments() {
        return equipments;
    }
    
    public List<Player> getOwners() {
        return owners;
    }
    //display
    public void displayInfo() {
        System.out.println("Hero ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Base - Attack: " + baseAttack +"\nDefense: " + baseDefense +"\nHealth: " + baseHealth);
    }
}