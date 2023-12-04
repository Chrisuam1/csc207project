package entities;
public class Leaderboard {
    private Player[] players;

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public int getPlayerPosition(Player player) throws Exception {
        int len = this.players.length;
        if (len == 0) {
            throw new Exception("Warning: no players");
        }
        for (Player p : this.players) {
            if (p.equals(player)) {
                //return player.getScore();
            }

        }
        return 0;
    }
}
