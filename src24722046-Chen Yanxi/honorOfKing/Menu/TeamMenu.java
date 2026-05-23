package honorOfKing.Menu;

import honorOfKing.KeyClass.*;
import java.util.Scanner;
import java.util.List;

public class TeamMenu {
    private Player currentPlayer;
    private List<Team> teams;
    private Scanner scanner;
    
    public TeamMenu(Player currentPlayer, List<Team> teams, Scanner scanner) {
        this.currentPlayer = currentPlayer;
        this.teams = teams;
        this.scanner = scanner;
    }
    
    public void showMenu() {
        while (true) {
            System.out.println("\nTEAM MANAGEMENT");
            System.out.println("1. Create Team");
            System.out.println("2. Join Team");
            System.out.println("3. Leave Team");
            System.out.println("4. View Team Info");
            System.out.println("5. Back to Player Menu");
            System.out.print("Select option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    createTeam();
                    break;
                case 2:
                    joinTeam();
                    break;
                case 3:
                    leaveTeam();
                    break;
                case 4:
                    viewTeamInfo();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    
    private void createTeam() {
        if (currentPlayer.getTeam() != null) {//check
            System.out.println("You must leave your current team first!");
            return;
        }
   //get team info     
        System.out.print("Enter Team ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Team Name: ");
        String name = scanner.nextLine();
   //create new team      
        Team newTeam = new Team(id, name);
        teams.add(newTeam);
        currentPlayer.joinTeam(newTeam);
        System.out.println("Team created successfully! You are now the first member.");
    }
    
    private void joinTeam() {
        if (currentPlayer.getTeam() != null) {//check
            System.out.println("You must leave your current team first!");
            return;
        }      
    System.out.println("\nAVAILABLE TEAMS");//displaye available teams for choose
        for (int i = 0; i < teams.size(); i++) {
            Team t = teams.get(i);
            System.out.println((i+1) + ". " + t.getName() +" (" + t.getPlayers().size() + " members)");
        }       
        System.out.print("Select team to join: ");
        int selection = scanner.nextInt();//get choose team
        scanner.nextLine();
  //autnticATION      
        if (selection > 0 && selection <= teams.size()) {
            Team selectedTeam = teams.get(selection - 1);
            currentPlayer.joinTeam(selectedTeam);
            System.out.println("Successfully joined " + selectedTeam.getName() + "!");
        } else {
            System.out.println("Invalid selection!");
        }
    }
    
    private void leaveTeam() {
        if (currentPlayer.getTeam() == null) {
            System.out.println("You're not in any team!");
            return;
        }       
        currentPlayer.leaveTeam();
        System.out.println("You have left your team successfully.");
    }
    
    private void viewTeamInfo() {
        if (currentPlayer.getTeam() == null) {
            System.out.println("You're not in any team!");
            return;
        }
 //get current team(check)and display info   
        Team team = currentPlayer.getTeam();
        System.out.println("\nTEAM DETAILS: " + team.getName());
        team.displayInfo();
 //display players       
        System.out.println("\nTEAM MEMBERS");
        for (Player member : team.getPlayers()) {
            member.displayInfo();
            System.out.println("---------------");
        }
    }
}