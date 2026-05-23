package honorOfKing.KeyClass;

import java.util.ArrayList;
import java.util.List;

public class Equipment {
    private String id;
    private String name;
    private String type;
    private int attackBonus;//attack added
    private int defenseBonus;//defense added
    private int healthBonus;//health value added
    private double rating;//equipments rate
    private List<Hero> heroes;//heroes use this equipment
    
    public Equipment(String id, String name, String type, int attackBonus, int defenseBonus, int healthBonus) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        this.healthBonus = healthBonus;
        this.rating = 0;
        this.heroes = new ArrayList<>();
    }
    
    public void addHero(Hero hero) {
        heroes.add(hero);
        calculateRating();
    }
    
    private void calculateRating() {
        if (heroes.isEmpty()) {
            rating = 0;
        } else {
            rating = (attackBonus + defenseBonus + healthBonus) / 3.0;//average attribute value
        }
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
    
    public int getAttackBonus() {
        return attackBonus;
    }
    
    public int getDefenseBonus() {
        return defenseBonus;
    }
    
    public int getHealthBonus() {
        return healthBonus;
    }
    
    public double getRating() {
        return rating;
    }
    
    public int getUsageCount() {//use count
        return heroes.size();
    }
    
    public List<Hero> getHeroes() {
        return heroes;
    }
    //display
    public void displayInfo() {
        System.out.println("Equipment ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Bonuses - Attack: " + attackBonus +"\nDefense: " + defenseBonus +"\nHealth: " + healthBonus);
        System.out.println("Rating: " + String.format("%.1f", rating));
        System.out.println("Usage Count: " + getUsageCount());
    }
}