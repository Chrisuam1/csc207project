package entity_tests;

import entities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;


    @BeforeEach
    void init() {
        player = new Player();
        player.setName("Euf");
        player.setScore(15);
    }

    @Test
    void getName() {assertEquals("Euf", player.getName());}

    @Test
    void getScore() {assertEquals(15, player.getScore());}




}