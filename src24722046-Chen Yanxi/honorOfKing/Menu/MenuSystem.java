package honorOfKing.Menu;

import honorOfKing.KeyClass.*;
import honorOfKing.util.Initialize;
import java.util.Scanner;
import java.util.List;

public class MenuSystem {
    private Scanner scanner;
    private List<Player> players;//player list
    private List<Team> teams;//team list
    private List<Hero> heroes;//hero list
    private List<Equipment> equipments;//equipment list
    private List<Match> matches;//match list
    private Administrator admin;
    
    public MenuSystem() {
        this.scanner = new Scanner(System.in);
        Initialize initializer = new Initialize();
        this.players = initializer.getPlayers();
        this.teams = initializer.getTeams();
        this.heroes = initializer.getHeroes();
        this.equipments = initializer.getEquipments();
        this.matches = initializer.getMatches();
        this.admin = initializer.getAdmin();
    }
    
    public void start() {//start main system circle(Login for player or admin)
        System.out.println("---- HonorOfKing Management System ----");
        //print main menu
        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Player Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit System");
            System.out.print("Select option: ");
            
            int choice = scanner.nextInt();//input
            scanner.nextLine();           
            switch (choice) {
                case 1:
                    playerLogin();
                    break;
                case 2:
                    adminLogin();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    
    
  //1
    private void playerLogin() {
        System.out.print("\nEnter Player ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        //get player identification
        Player player = findPlayerById(id);
        if (player != null && player.authenticate(password)) {
            System.out.println("\nLogin successful! Welcome to HonorOfKing " + player.getName());
            PlayerMenu playerMenu = new PlayerMenu(player, players, teams, heroes, equipments, matches, scanner);//display player menu
            playerMenu.showMenu();
        } 
        else {
            System.out.println("Invalid input!");
        }
    }
    private Player findPlayerById(String id) {
        for (Player player : players) {
            if (player.getId().equals(id)) {
                return player;
            }
        }
        return null;
    }
    
    
  //2
    private void adminLogin() {
        System.out.print("\nEnter Admin ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
 //get admin identification       
        if (admin.getId().equals(id) && admin.authenticate(password)) {
            System.out.println("\nAdmin access successfully!");
            AdminMenu adminMenu = new AdminMenu(admin, players, teams, heroes, equipments, matches, scanner);//display admin menu
            adminMenu.showMenu();
        } 
        else {
            System.out.println("Invalid input!");
        }
    }
    
 
}