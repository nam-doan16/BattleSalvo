package cs3500.pa04.model.players;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Test class for Computer player
 */
class ComputerPlayerTest {

  /**
   * Test instantiation
   */
  @Test
  public void testConstructor() {
    AbstPlayer player = new ComputerPlayer(6, 6, new Random(6));
    assertEquals(player.name(), "Computer Player");
  }

}