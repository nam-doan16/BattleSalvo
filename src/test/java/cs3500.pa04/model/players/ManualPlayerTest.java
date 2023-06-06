package cs3500.pa04.model.players;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Test class for ManualPlayer
 */
class ManualPlayerTest {

  /**
   * Testing instantiation
   */
  @Test
  public void testConstructor() {
    AbstPlayer player = new ManualPlayer("Nam Doan", 6, 6, new Random());
    assertEquals(player.name(), "Nam Doan");
  }


}