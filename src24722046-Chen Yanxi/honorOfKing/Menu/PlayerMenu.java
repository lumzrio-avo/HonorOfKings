package honorOfKing.Menu;

import honorOfKing.KeyClass.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PlayerMenu {

    private List<Player> players;//player list
    private List<Team> teams;//team list
    private List<Hero> heroes;//heroes list
    private List<Equipment> equipments;//equipments lists
    private List<Match> matches;//match list
    private Player currentPlayer;//
    private Scanner scanner;
    
    public PlayerMenu(Player currentPlayer, List<Player> players, List<Team> teams, 
                     List<Hero> heroes, List<Equipment> equipments, List<Match> matches, Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.players = players;
        this.teams = teams;
        this.heroes = heroes;
        this.equipments = equipments;
        this.matches = matches;
        this.scanner = scanner;
    }
//first display main menu for users    
    public void showMenu() {
        while (true) {
            System.out.println("\nPLAYER DASHBOARD - " + currentPlayer.getName());
            System.out.println("1. My Profile");
            System.out.println("2. My Heroes");
            System.out.println("3. Team Management");
            System.out.println("4. Match History");
            System.out.println("5. Equipment Stats");
            System.out.println("6. Leaderboards");
            System.out.println("7. Logout");
            System.out.print("Select option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    showProfile();
                    break;
                case 2:
                    showHeroes();
                    break;
                case 3:
                    TeamMenu teamMenu = new TeamMenu(currentPlayer, teams, scanner);//display team menu
                    teamMenu.showMenu();
                    break;
                case 4:
                    showMatchHistory();
                    break;
                case 5:
                    showEquipmentStats();
                    break;
                case 6:
                    showLeaderboards();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    
//different cases
    
    private void showProfile() {
        System.out.println("\nPLAYER PROFILE");
        currentPlayer.displayInfo();//display player's info
        System.out.println("Heroes Owned: " + currentPlayer.getHeroes().size());//owned heroes number
        System.out.println("Matches Played: " + currentPlayer.getMatches().size());//display competitions number
        System.out.println("Current Team: " +(currentPlayer.getTeam() != null ? currentPlayer.getTeam().getName() : "None"));
    }
    
    private void showHeroes() {
        System.out.println("\nMY HEROES");
        for (Hero hero : currentPlayer.getHeroes()) {
            hero.displayInfo();//display hero's info
            System.out.println("Equipped Items:");
         //display hero's equipped items
          for (Equipment eq : hero.getEquipments()) {
              System.out.println("- " + eq.getName());
            }
            System.out.println("---------------");
        }
    }
    
    private void showMatchHistory() {
        System.out.println("\nMATCH HISTORY");
        for (Match match : currentPlayer.getMatches()) {
            match.displayInfo();//display matches info
            System.out.println("---------------");
        }
    }
    
    private void showEquipmentStats() {
        System.out.println("\nEQUIPMENT STATISTICS");
        System.out.println("1. Most Used Equipment");
        System.out.println("2. Highest Rated Equipment");
        System.out.print("Select view: ");        
        int view = scanner.nextInt();
        scanner.nextLine();
        
        if (view == 1) {
        	
    //rank by use count
            equipments.sort((e1, e2) -> e2.getUsageCount() - e1.getUsageCount());
        } 
        else if (view == 2) {
        	 //rank by rating     
            equipments.sort((e1, e2) -> Double.compare(e2.getRating(), e1.getRating()));
        }
  //display the top 5th list
        System.out.println("\nTOP EQUIPMENT");
        for (int i = 0; i < Math.min(5, equipments.size()); i++) {
            Equipment e = equipments.get(i);
            System.out.println((i+1) + "." + e.getName() +(view == 1 ? " (Used by " + e.getUsageCount() + " heroes)" :" (Rating: " + String.format("%.1f", e.getRating()) + ")"));
        }
    }
    
    private void showLeaderboards() {
        System.out.println("\nLEADERBOARDS");
        System.out.println("1. Global Leaderboard");
        System.out.println("2. Team Leaderboard");
        System.out.print("Select view: ");        
        int view = scanner.nextInt();
        scanner.nextLine();
        
        List<Player> rankedPlayers = new ArrayList<>();
        
        if (view == 1) {
        	
        	//global
            rankedPlayers.addAll(players);
        } 
        else if (view == 2) {
        	//among teams
            if (currentPlayer.getTeam() == null) {
                System.out.println("You're not in a team!");
                return;
            }
        //teams rank
            rankedPlayers.addAll(currentPlayer.getTeam().getPlayers());
        }
        //players' rank(by WinRate)
        rankedPlayers.sort((p1, p2) -> Double.compare(p2.getWinRate(), p1.getWinRate()));
        //display top 10 players
        System.out.println("\nTOP PLAYERS");
        for (int i = 0; i < Math.min(10, rankedPlayers.size()); i++) {
            Player p = rankedPlayers.get(i);
            System.out.println((i+1) + "." + p.getName() +" - Win Rate: " + String.format("%.1f", p.getWinRate()) + "%" + " - Level: " + p.getLevel());
        }
    }
}