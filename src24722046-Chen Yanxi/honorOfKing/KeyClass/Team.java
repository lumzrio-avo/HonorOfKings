package honorOfKing.KeyClass;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String id;
    private String name;
    private List<Player> players;//players belong to team
    private List<Match> matches;//matches recording
    
    public Team(String id, String name) {
        this.id = id;
        this.name = name;
        this.players = new ArrayList<>();
        this.matches = new ArrayList<>();
    }
    
    public void addPlayer(Player player) {
        if (!players.contains(player)) {//check player are not in the team
            players.add(player);
        }
    }
    
    public void removePlayer(Player player) {
        players.remove(player);
    }
    
    public void addMatch(Match match) {
        matches.add(match);
    }
    //getter
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    public List<Match> getMatches() {
        return matches;
    }
    
    public double getTeamWinRate() {//related to personal player
        int totalWins = 0;//wins number
        int totalMatches = 0;//total number
        
        for (Player player : players) {//players' wins & total matches number
            totalWins += player.getWins();
            totalMatches += player.getWins() + player.getLosses();
        }
        
        if (totalMatches == 0) return 0;//check already join games
        return (double) totalWins / totalMatches * 100;
    }
    
    public double getAverageLevel() {
        if (players.isEmpty()) return 0;//check       
        int totalLevel = 0;
        for (Player player : players) {
            totalLevel += player.getLevel();//related to personal player's level
        }        
        return (double) totalLevel / players.size();
    }
    //display
    public void displayInfo() {
        System.out.println("Team ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Number of Players: " + players.size());
        System.out.println("Average Level: " + String.format("%.1f", getAverageLevel()));
        System.out.println("Team Win Rate: " + String.format("%.2f", getTeamWinRate()) + "%");
    }
}