package test.entities;

import entities.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class PlayerTest {

    private Player player;


    @Before
    public void init() {
        player = new Player("Euf");
        player.setScore(15);
    }

    @Test
    public void getName() {assertEquals("Euf", player.getName());}

    @Test
    public void getScore() {assertEquals(15, player.getScore(), 0);}

    @Test
    public void getId() {assertEquals(1, player.getId());}


}