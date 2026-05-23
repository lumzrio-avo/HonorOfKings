package honorOfKing.Menu;

import honorOfKing.KeyClass.*;
import java.util.Scanner;
import java.util.List;

public class AdminMenu {
    private Administrator admin;
    private List<Player> players;
    private List<Team> teams;
    private List<Hero> heroes;
    private List<Equipment> equipments;
    private List<Match> matches;
    private Scanner scanner;
    
    public AdminMenu(Administrator admin, List<Player> players, List<Team> teams,List<Hero> heroes, List<Equipment> equipments, List<Match> matches, Scanner scanner) {
        this.admin = admin;
        this.players = players;
        this.teams = teams;
        this.heroes = heroes;
        this.equipments = equipments;
        this.matches = matches;
        this.scanner = scanner;
    }
    //show menu home page
    public void showMenu() {
        while (true) {
            System.out.println("\nADMIN DASHBOARD");
            System.out.println("1. Manage Players");
            System.out.println("2. Manage Teams");
            System.out.println("3. Manage Heroes");
            System.out.println("4. Manage Equipment");
            System.out.println("5. Manage Matches");
            System.out.println("6. View System Statistics");
            System.out.println("7. Logout");
            System.out.print("Select option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();           
            switch (choice) {
                case 1:
                    managePlayers();
                    break;
                case 2:
                    manageTeams();
                    break;
                case 3:
                    manageHeroes();
                    break;
                case 4:
                    manageEquipment();
                    break;
                case 5:
                    manageMatches();
                    break;
                case 6:
                    viewStatistics();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    //case1:player menu home page
    private void managePlayers() {
        while (true) {
            System.out.println("\nPLAYER MANAGEMENT");
            System.out.println("1. Add New Player");
            System.out.println("2. Edit Player");
            System.out.println("3. Delete Player");
            System.out.println("4. View All Players");
            System.out.println("5. Back to Admin Menu");
            System.out.print("Select option: ");
 //input           
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1://add new player
                    System.out.print("Enter Player ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Player Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();                    
                    players.add(new Player(id, name, password));
                    System.out.println("Player added successfully!");
                    break;
                    
                case 2://edit player info(change name&password)
                    System.out.print("Enter Player ID to edit: ");
                    String editId = scanner.nextLine();
                    
                    Player playerToEdit = findPlayerById(editId);
                    if (playerToEdit != null) {
                        System.out.print("Enter new name (current: " + playerToEdit.getName() + "): ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new password: ");
                        String newPass = scanner.nextLine();
                        
                        int index = players.indexOf(playerToEdit);
                        if (index != -1) {
                            players.set(index, new Player(editId, newName, newPass));
                            System.out.println("Player updated!");
                        }
                    } else {
                        System.out.println("Player not found!");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter Player ID to delete: ");
                    String delId = scanner.nextLine();
                    
                    Player playerToDelete = findPlayerById(delId);
                    if (playerToDelete != null) {
                        players.remove(playerToDelete);
                        System.out.println("Player deleted!");
                    } else {
                        System.out.println("Player not found!");
                    }
                    break;
                    
                case 4:
                    System.out.println("\nALL PLAYERS");
                    for (Player p : players) {
                        p.displayInfo();
                        System.out.println("------------------");
                    }
                    break;
                    
                case 5:
                    return;
                    
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    //team home page(same to player)
    private void manageTeams() {
        
    }
    //hero home page
    private void manageHeroes() {
       
    }
    //equipment home page
    private void manageEquipment() {
       
    }
    
    private void manageMatches() {
        
    }
  //display  
    private void viewStatistics() {
        System.out.println("\nSYSTEM STATISTICS");
        System.out.println("Total Players: " + players.size());
        System.out.println("Total Teams: " + teams.size());
        System.out.println("Total Heroes: " + heroes.size());
        System.out.println("Total Equipment: " + equipments.size());
        System.out.println("Total Matches: " + matches.size());
    }
    
    private Player findPlayerById(String id) {
        for (Player p : players) {
            if (p.getId().equals(id)) {//match
                return p;
            }
        }
        return null;
    }
}