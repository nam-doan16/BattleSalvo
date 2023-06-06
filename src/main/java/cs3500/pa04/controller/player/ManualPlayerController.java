package cs3500.pa04.controller.player;

import cs3500.pa04.controller.ReaderInterface;
import cs3500.pa04.model.players.ManualPlayer;
import cs3500.pa04.view.View;
import java.util.Random;

/**
 * Represents a Manual player controller
 */
public class ManualPlayerController extends AbstPlayerController {

  /**
   * Constructor for ManualPlayerController
   *
   * @param input ReaderInterface object
   * @param view view object
   * @param height height of board
   * @param width width of board
   * @param rand Random object
   */
  public ManualPlayerController(ReaderInterface input, View view,
                                int height, int width, Random rand) {
    super(new ManualPlayer("", height, width, rand), view, input, height, width);
  }



}
