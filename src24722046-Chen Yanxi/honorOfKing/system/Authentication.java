package honorOfKing.system;

import java.util.ArrayList;

import honorOfKing.KeyClass.Administrator;
import honorOfKing.KeyClass.Player;


public class Authentication {
	//constructor
    public static Player authenticatePlayer(String id, String password, ArrayList<Player> players) {
        for (Player player : players) {
        	//two authentications
            if (player.getId().equals(id) && player.authenticate(password)) {
                return player;
            }
        }
        return null;
    }
    
    public static boolean authenticateAdmin(String id, String password, Administrator admin) {
        return admin.getId().equals(id) && admin.authenticate(password);
    }
}