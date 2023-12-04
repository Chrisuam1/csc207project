package entity_tests;

import entities.Leaderboard;
import org.junit.jupiter.api.BeforeEach;
import entities.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LeaderboardTest {
    private Player player_1;
    private Player player_2;
    private ArrayList<Player> players;
    private Leaderboard leaderboard;

    @BeforeEach
    void init() {
        player_1 = new Player();
        player_2 = new Player();
        player_1.setName("Aaron");
        player_2.setName("Honey");
        players = new ArrayList<>();
        players.add(player_1);
        players.add(player_2);
        leaderboard.setPlayers(players);
    }

    @Test
    void getPlayers() {assertEquals(players, leaderboard.getPlayers());}

    //    @Test
    //    void getPlayerPosition() {assertEquals();}


}