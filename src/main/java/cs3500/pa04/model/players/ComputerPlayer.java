package cs3500.pa04.model.players;

import java.util.Random;

/**
 * Represents a Computer AI Player
 */
public class ComputerPlayer extends AbstPlayer {

  /**
   * Constructor for ComputerPlayer
   *
   * @param height height of board
   * @param width width of board
   * @param rand Random object
   */
  public ComputerPlayer(int height, int width, Random rand) {
    super("Computer Player", height, width, rand);
  }
}
