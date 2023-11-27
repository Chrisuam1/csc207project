package entities;

import java.util.ArrayList;
import java.util.Collections;

public class Leaderboard {
    private ArrayList<Player> players;

    public Leaderboard() {
        this.players = new ArrayList<>();
    }

    /**
     * Adds a player to the leaderboard, then immediately sorts it.
     * @param player
     */
    public void addPlayer(Player player) {
        players.add(player);
        players.sort(Collections.reverseOrder());
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * returns the current rank of a player in a leader board, 1 being the highest rank.
     * precondition: leaderboard must be sorted by score (descending).
     * @param player
     * @return the current rank of the player
     * @throws Exception when leaderboard is empty or player isn't on leaderboard
     */
    public int getPlayerRank(Player player) throws Exception {
        int numPlayers = this.players.size();
        if (numPlayers == 0) {
            throw new Exception("Warning: no players");
        }

        // look for player in leaderboard
        int rank = 1;
        for (Player p : this.players) {
            if (player.getId() == p.getId()) {
                return rank;
            }
            rank++;
        }

        // player not found in leaderboard
        throw new Exception("Player is not in leaderboard");
    }
}
