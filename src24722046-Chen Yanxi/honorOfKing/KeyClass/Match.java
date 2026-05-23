package honorOfKing.KeyClass;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private String id;
    private Team team1;
    private Team team2;
    private Team winner;
    private List<Player> participants;
    private List<Hero> heroPicks;
    
    public Match(String id, Team team1, Team team2) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.participants = new ArrayList<>();
        this.heroPicks = new ArrayList<>();
    }
    
    public void setWinner(Team winner) {
        this.winner = winner;        
        // Update player recording
        for (Player player : participants) {
            if (winner == player.getTeam()) {
                player.recordWin();//add win number
            } 
            else {
                player.recordLoss();//add loss number
            }
        }
        
        // Add match recording to teams
        team1.addMatch(this);
        team2.addMatch(this);
    }
    
    public void addParticipant(Player player) {
        participants.add(player);
        player.addMatch(this);
    }
    
    public void addHeroPick(Hero hero) {
        heroPicks.add(hero);
    }
    //getter
    public String getId() {
        return id;
    }
    
    public Team getTeam1() {
        return team1;
    }
    
    public Team getTeam2() {
        return team2;
    }
    
    public Team getWinner() {
        return winner;
    }
    
    public List<Player> getParticipants() {
        return participants;
    }
    
    public List<Hero> getHeroPicks() {
        return heroPicks;
    }
    //display
    public void displayInfo() {
        System.out.println("Match ID: " + id);
        System.out.println("Teams: " + team1.getName() + " vs " + team2.getName());
        if (winner != null) {
            System.out.println("Winner: " + winner.getName());
        } else {
            System.out.println("Result: Not determined yet");
        }
    }
}