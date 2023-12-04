package test.entities;

import entities.Leaderboard;
import entities.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LeaderboardTest {
    private Player player_1;
    private Player player_2;
    private ArrayList<Player> players;
    private Leaderboard leaderboard;

    @Before
    public void init() {
        player_1 = new Player("Aaron");
        player_2 = new Player("Honey");
        leaderboard = new Leaderboard();
        players = new ArrayList<>();
        players.add(player_1);
        players.add(player_2);
        leaderboard.addPlayer(player_1);
        leaderboard.addPlayer(player_2);
    }

    @Test
    public void getPlayers() {assertEquals(players, leaderboard.getPlayers());}
}