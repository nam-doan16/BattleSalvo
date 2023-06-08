package cs3500.pa04.controller.player;

import cs3500.pa04.controller.input.ReaderInterface;
import cs3500.pa04.model.players.ComputerPlayer;
import cs3500.pa04.model.types.Coord;
import cs3500.pa04.model.types.ShipType;
import cs3500.pa04.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Represents a Computer Player Controller
 */
public class ComputerPlayerController extends AbstPlayerController {
  private ArrayList<Coord> boardChoices;
  private final Random rand;

  /**
   * Constructor for ComputerPlayerController
   *
   * @param input ReaderInterface object
   * @param height height of the board
   * @param width width of the board
   * @param view view object
   * @param rand random object for randomization
   */
  public ComputerPlayerController(ReaderInterface input, int height,
                                  int width, View view, Random rand) {
    super(new ComputerPlayer(height, width, rand), view, input, height, width);
    this.rand = rand;
    this.addBoardChoices(height, width);
  }

  /**
   * Adds all possible coordinate choices into the field storing it
   *
   * @param height height of the board
   * @param width width of the board
   */
  private void addBoardChoices(int height, int width) {
    this.boardChoices = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        boardChoices.add(new Coord(j, i));
      }
    }
  }

  /**
   * Gets maxShots amount of random coordinates from boardChoices and returns it all
   *
   * @param maxShots maximum shots that can be sent to the opponent
   * @return list of unique random shots
   */
  @Override
  public List<Coord> getShots(int maxShots) {
    ArrayList<Coord> shots = new ArrayList<>();
    for (int i = 0; i < maxShots; i++) {
      shots.add(this.boardChoices.remove(rand.nextInt(this.boardChoices.size())));
    }
    player.setShots(shots);
    return player.takeShots();
  }

  /**
   * Gets the name of this computer player
   *
   * @return "Computer Player"
   */
  @Override
  public String getName() {
    return "Computer Player";
  }

  /**
   * Gets a randomized fleet size depending on the maxFleet
   *
   * @param maxFleet maximum fleets that can be on the board
   * @return Hashmap with each ship and their corresponding random quantities
   */
  @Override
  public HashMap<ShipType, Integer> getFleetSize(int maxFleet) {
    HashMap<ShipType, Integer> tempFleet = new HashMap<>();
    tempFleet.put(ShipType.CARRIER, 1);
    tempFleet.put(ShipType.BATTLESHIP, 1);
    tempFleet.put(ShipType.DESTROYER, 1);
    tempFleet.put(ShipType.SUBMARINE, 1);
    for (int i = 4; i < maxFleet; i++) {
      int shipTypeIndex = this.rand.nextInt(ShipType.values().length);
      int currentFleetAmount = tempFleet.get(ShipType.values()[shipTypeIndex]);
      tempFleet.put(ShipType.values()[shipTypeIndex], currentFleetAmount + 1);
    }

    return tempFleet;
  }
}
