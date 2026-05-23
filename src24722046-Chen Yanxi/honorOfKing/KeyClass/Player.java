package honorOfKing.KeyClass;

import java.util.ArrayList;
import java.util.List;

public class Player extends Person {
    private Team team;//own team
    private List<Hero> heroes;//own heroes list
    private List<Match> matches;//matches recording
    private int level;
    private int wins;//win matches number
    private int losses;//loss matches number
    private String password;
    
    public Player(String id, String name, String password) {
        super(id, name);
        this.heroes = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.level = 1;
        this.wins = 0;
        this.losses = 0;
        this.password = password;
    }
    
    public void joinTeam(Team team) {
        this.team = team;
        team.addPlayer(this);
    }
    
    public void leaveTeam() {
        if (team != null) {//check
            team.removePlayer(this);
            team = null;
        }
    }
    
    public void addHero(Hero hero) {
        heroes.add(hero);
    }
    
    public void addMatch(Match match) {
        matches.add(match);
    }
    
    public void recordWin() {
        wins++;
    }
    
    public void recordLoss() {
        losses++;
    }
    
    public double getWinRate() {
        if (wins + losses == 0) return 0;//ensure attend the game
        return (double) wins / (wins + losses) * 100;
    }
    //getter
    public Team getTeam() {
        return team;
    }
    
    public List<Hero> getHeroes() {
        return heroes;
    }
    
    public List<Match> getMatches() {
        return matches;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void levelUp() {
        level++;
    }
    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
    public boolean authenticate(String password) {
        return this.password.equals(password);
    }
    
    @Override
    public void displayInfo() {//subclass(player own info display)
        System.out.println("Player ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Win Rate: " + String.format("%.2f", getWinRate()) + "%");//fixed format
        if (team != null) {//check
            System.out.println("Team: " + team.getName());
        }
    }
}