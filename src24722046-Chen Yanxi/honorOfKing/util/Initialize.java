package honorOfKing.util;

import honorOfKing.KeyClass.*;
import java.util.ArrayList;
import java.util.List;

public class Initialize {
    private List<Player> players;
    private List<Team> teams;
    private List<Hero> heroes;
    private List<Equipment> equipments;
    private List<Match> matches;
    private Administrator admin;
    
public Initialize()    	
{       initializePlayers();
        initializeTeams();
        initializeHeroes();
        initializeEquipment();
        initializeMatches();
        initializeAdmin();
        setupRelationships();// Establish relationships
    }
    
    private void initializePlayers() {//initialize player format
        players = new ArrayList<>();
        players.add(new Player("P001", "PlayerOne", "pass1"));
        players.add(new Player("P002", "PlayerTwo", "pass2"));
        players.add(new Player("P003", "PlayerThree", "pass3"));
        players.add(new Player("P004", "PlayerFour", "pass4"));
    }
    
    private void initializeTeams() {//team format
        teams = new ArrayList<>();
        teams.add(new Team("T001", "Dragon Team"));
        teams.add(new Team("T002", "Phoenix Squad"));
    }
    
    private void initializeHeroes() {//hero format(init)
        heroes = new ArrayList<>();
        heroes.add(new Hero("H001", "Luban", "Marksman", 85, 45, 70));
        heroes.add(new Hero("H002", "Diaochan", "Mage", 90, 40, 65));
        heroes.add(new Hero("H003", "Zhao Yun", "Assassin", 95, 50, 80));
        heroes.add(new Hero("H004", "Arthur", "Tank", 70, 90, 100));
    }
    
    private void initializeEquipment() {//equipment format(init)
        equipments = new ArrayList<>();
        equipments.add(new Equipment("E001", "Blade of Despair", "Attack", 120, 0, 0));
        equipments.add(new Equipment("E002", "Wind of Nature", "Attack", 80, 0, 30));
        equipments.add(new Equipment("E003", "Immortality", "Defense", 40, 60, 40));
        equipments.add(new Equipment("E004", "Athena's Shield", "Defense", 0, 120, 0));
    }
    
    private void initializeMatches() {
        matches = new ArrayList<>();
        Match match1 = new Match("M001", teams.get(0), teams.get(1));
        match1.setWinner(teams.get(0));
        matches.add(match1);
        
        Match match2 = new Match("M002", teams.get(0), teams.get(1));
        match2.setWinner(teams.get(1));
        matches.add(match2);
    }
    
    private void initializeAdmin() {
        admin = new Administrator("A001", "Admin", "admin123");
        admin = new Administrator("A002", "Admin", "admin456");
    }
    
    private void setupRelationships() {
        // Assign players to teams
     players.get(0).joinTeam(teams.get(0));//player0->team0
       players.get(1).joinTeam(teams.get(0));
        players.get(2).joinTeam(teams.get(1));
       players.get(3).joinTeam(teams.get(1));
        
        // Assign heroes to players
players.get(0).addHero(heroes.get(0));
 players.get(0).addHero(heroes.get(1));
players.get(1).addHero(heroes.get(2));
players.get(2).addHero(heroes.get(3));
 players.get(3).addHero(heroes.get(0));
  players.get(3).addHero(heroes.get(3));
        
// Assign equipment to heroes
heroes.get(0).addEquipment(equipments.get(0));
 heroes.get(0).addEquipment(equipments.get(1));
heroes.get(1).addEquipment(equipments.get(2));
heroes.get(2).addEquipment(equipments.get(3));
heroes.get(3).addEquipment(equipments.get(0));
        
// Add players to matches
for (Player player : players) {
    for (Match match : matches) {
     match.addParticipant(player);
            }
        }
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    public List<Team> getTeams() {
        return teams;
    }
    
    public List<Hero> getHeroes() {
        return heroes;
    }
    
    public List<Equipment> getEquipments() {
        return equipments;
    }
    
    public List<Match> getMatches() {
        return matches;
    }
    
    public Administrator getAdmin() {
        return admin;
    }
}